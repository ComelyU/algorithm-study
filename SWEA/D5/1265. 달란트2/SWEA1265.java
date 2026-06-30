import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1265 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            // 각 묶음에 들어있는 달란트 수의 차이가 최소인 경우 곱했을 때 얻는 사탕의 수가 크다.
            // 즉, N개를 묶음 P로 나눈 각 묶음의 숫자의 차이가 작아야만 곱했을 때 값이 커진다.

            int quotient = N / P;
            int remainder = N % P;

            int[] bundles = new int[P];
            Arrays.fill(bundles, quotient);

            while(remainder-- > 0) {
                bundles[remainder]++;
            }

            long candy = 1;
            for(int bundle : bundles) {
                candy *= bundle;
            }

            sb.append('#').append(testCase).append(' ').append(candy).append('\n');
        }

        System.out.println(sb.toString());
    }
}