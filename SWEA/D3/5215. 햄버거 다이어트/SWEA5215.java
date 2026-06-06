import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] dp;
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); // 재료의 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            dp = new int[L + 1]; // dp[x]는 x 칼로리의 햄버거일 때 얻을 수 있는 맛의 최대 점수
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());

                // 제한 칼로리부터 현재 재료의 칼로리까지 역순 탐색 (재료 중복 선택 방지)
                for(int cal = L; cal >= calorie; cal--) {
                    dp[cal] = Math.max(dp[cal], dp[cal - calorie] + score);
                }
            }

            sb.append('#').append(testCase).append(' ').append(dp[L]).append('\n');
        }

        System.out.println(sb.toString());
    }

}
