import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA26009 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        final long MOD = 998_244_353;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // 등차수열의 합 공식: n * (n + 1) / 2
            long sumA = (a * (a + 1) / 2) % MOD;
            long sumB = (b * (b + 1) / 2) % MOD;
            long sumC = (c * (c + 1) / 2) % MOD;

            // 곱셈 분배법칙 적용: (sumA * sumB * sumC) % MOD
            long answer = (((sumA * sumB) % MOD) * sumC) % MOD;

            sb.append(answer).append('\n');
        }

        System.out.println(sb.toString());
    }

}
