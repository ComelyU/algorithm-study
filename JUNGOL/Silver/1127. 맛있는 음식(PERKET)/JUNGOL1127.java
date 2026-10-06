import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1127 {

    private static int N;
    private static int[] sour;
    private static int[] bitter;
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        getMinDiff(0, 1, 0, 0);

        System.out.println(minDiff);
    }

    // DFS with Backtracking
    private static void getMinDiff(int index, int sourProduct, int bitterSum, int count) {
        if (index == N) {
            if (count > 0) {
                int diff = Math.abs(sourProduct - bitterSum);
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }

        getMinDiff(index + 1, sourProduct * sour[index], bitterSum + bitter[index], count + 1);
        getMinDiff(index + 1, sourProduct, bitterSum, count);
    }

}
