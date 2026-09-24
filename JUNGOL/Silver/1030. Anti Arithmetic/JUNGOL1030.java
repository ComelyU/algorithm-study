import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1030 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), ": ");

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[Integer.parseInt(st.nextToken())] = i;
            }

            boolean isAntiArithmetic = true;
            for (int first = 0; first < n; first++) {
                for (int diff = 1; first + diff * 2 < n; diff++) {
                    int second = first + diff;
                    int third = second + diff;

                    if ((pos[first] < pos[second] && pos[second] < pos[third]) ||
                    (pos[first] > pos[second] && pos[second] > pos[third])) {
                        isAntiArithmetic = false;
                        break;
                    }
                }

                if (!isAntiArithmetic) {
                    break;
                }
            }

            sb.append(isAntiArithmetic ? "yes" : "no").append('\n');
        }

        System.out.println(sb);
    }

}
