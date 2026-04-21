import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3067 {

    private static int[] coins;
    private static int M;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            coins = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dpSolve();
            sb.append(dp[M]).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 1차원 dp 사용
    private static void dpSolve() {
        dp = new int[M + 1];

        dp[0] = 1; // 0원을 만드는 방법의 수는 1개.
        for(int coin : coins) { // 어떤 금액의 동전을 사용하는지 결정
            for(int price = coin; price <= M; price++) {
                dp[price] += dp[price - coin];
            }
        }
    }
}
