import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

//            int result = 0;
//            for (int i = 1; i <= N; i++) {
//                if (i % 2 == 0) { // (i & 1) == 0
//                    result -= i;
//                } else {
//                    result += i;
//                }
//            }

            // 규칙성: 수열을 두 개씩 묶으면 짝수 번째 항까지는 -1씩 누적
            // N이 짝수: -(N / 2)
            // N이 홀수: 직전 짝수까지의 결과에 N 더하기 -((N - 1) / 2) + N = (N + 1) / 2
            int result = N % 2 == 0 ? -(N / 2) : (N + 1) / 2;

            sb.append('#').append(tc).append(' ').append(result).append('\n');
        }

        System.out.print(sb);
    }

}
