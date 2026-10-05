import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA22574 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int floor = 0;
            for (int i = 1; i <= N; i++) {
                floor += i;

                if (floor == P) {
//                    floor--;
                    floor = N * (N + 1) / 2 - 1; // 윗 라인 주석풀어서 반복문 끝까지 돌려도 됨.
                    break;
                }
            }

            sb.append(floor).append('\n');
        }

        System.out.println(sb);
    }

}
