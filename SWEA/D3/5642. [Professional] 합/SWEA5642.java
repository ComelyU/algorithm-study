import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5642 {

    // 카데인 알고리(Kadane's Algorithm) 풀이 (DP)
    // 배열을 한 번만 순회하며 '이전 합에 현재 원소를 더할지' 또는 '현재 원소부터 새로 시작할지'를 선택해 최대 부분합을 O(n) 시간에 구하는 방법
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

//            int max = Integer.MIN_VALUE;
//            int sum = 0;
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < N; i++) {
//                sum += Integer.parseInt(st.nextToken());
//
//                max = Math.max(max, sum);
//
//                // 누적합이 음수 -> 다음 합 연산에 손해. 따라서 0으로 리셋.
//                if (sum < 0) {
//                    sum = 0;
//                }
//            }

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[0];
            int sum = arr[0];

            for (int i = 1; i < N; i++) {
                sum = Math.max(arr[i], sum + arr[i]);
                max = Math.max(max, sum);
            }

            sb.append('#').append(tc).append(' ').append(max).append('\n');
        }

        System.out.print(sb);
    }

//    // DP 배열 풀이
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int tc = 1; tc <= T; tc++) {
//            int N = Integer.parseInt(br.readLine());
//
//            int[] arr = new int[N];
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < N; i++) {
//                arr[i] = Integer.parseInt(st.nextToken());
//            }
//
//            int[] dp = new int[N];
//            dp[0] = arr[0];
//
//            int max = dp[0];
//            for (int i = 1; i < N; i++) {
//                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
//                max = Math.max(max, dp[i]);
//            }
//
//            sb.append('#').append(tc).append(' ').append(max).append('\n');
//        }
//
//        System.out.print(sb);
//    }

}
