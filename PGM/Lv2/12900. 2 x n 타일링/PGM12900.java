public class PGM12900 {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];

        dp[1] = 1; // 세로로 배치하는 경우
        dp[2] = 2; // 세로만 2개 배치하는 경우와 가로만 2개 배치하는 경우
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }

}
