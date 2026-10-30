import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1011 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = getPrimes(M); // 에라토스테네스의 체 이용

        int clapCount = 0;

        for (int i = K + 1; i <= M; i += N) { // K + 1부터 시작(사람은 0 base, 369는 1 base)
            if (isPrime[i]) {
                clapCount++;
            }
        }

        System.out.println(clapCount);
    }

    private static boolean[] getPrimes(int maxNum) {
        boolean[] isPrime = new boolean[maxNum + 1];

        Arrays.fill(isPrime, true);

        if (maxNum >= 0) {
            isPrime[0] = false;
        }
        if (maxNum >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

}
