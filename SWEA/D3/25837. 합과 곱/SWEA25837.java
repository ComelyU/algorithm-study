import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SWEA25837 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            long S = Long.parseLong(st.nextToken()); // N + M
            long P = Long.parseLong(st.nextToken()); // N * M

//            sb.append(solveByQuadraticFormula(S, P) ? "Yes" : "No").append('\n');
            sb.append(solveByBinarySearch(S, P) ? "Yes" : "No").append('\n');
        }

        System.out.printf(sb.toString());
    }

    private static boolean solveByBinarySearch(long s, long p) {
        long left = 1;
        long right = s / 2; // N <= M 가정으로 하면 S / 2까지만 탐색하면 됨 (이분탐색 결과가 N 값)

        BigInteger targetP = BigInteger.valueOf(p);

        while (left <= right) {
            long mid = left + (right - left) / 2;

            BigInteger currentP = BigInteger.valueOf(mid).multiply(BigInteger.valueOf(s - mid));

            int compareP = currentP.compareTo(targetP);

            if (compareP == 0) {
                return true; // 만족하는 자연수 N, M 쌍을 찾음
            } else if (compareP < 0) {  // 곱이 커져야 함.
                left = mid + 1;
            } else { // 곱이 작아져야 함.
                right = mid - 1;
            }
        }

        return false; // 만족하는 자연수 N, M 쌍이 없음.
    }

    private static boolean solveByQuadraticFormula(long s, long p) {
        // N + M = S, N * M = P
        // N + M = S에서 M = S - N
        // N * M = N * (S - N) = P
        // N ^ 2 - S * N + P = 0
        // 근의 공식은 (S +- sqrt(S ^ 2 - 4 * P)) / 2
        // 판별식(discriminant) D = S ^ 2 - 4 * P 가 0 이상이어야 함. (BigInteger 사용으로 오버플로우 방지)
        BigInteger bigS = BigInteger.valueOf(s);
        BigInteger bigP = BigInteger.valueOf(p);
        BigInteger D = bigS.multiply(bigS).subtract(bigP.multiply(BigInteger.valueOf(4)));

        if (D.signum() < 0) { // compareTo(BigInteger.ZERO)도 가능.
            return false;
        }

        // D가 완전제곱수인지 판별
        long sqrtD = D.sqrt().longValue(); // Java 9부터 가능.
        BigInteger bigSqrtD = BigInteger.valueOf(sqrtD);
        if (bigSqrtD.multiply(bigSqrtD).compareTo(D) != 0) {
            return false;
        }

        // 근의 공식에서 분자가 짝수인지 확인 (s와 sqrtD의 홀짝 구분이 같아야 함)
        if ((s + sqrtD) % 2 != 0) {
            return false;
        }

        // 자연수 조건 확인 (N, M >= 1) minRoot = minSolution
        long minRoot = (s - sqrtD) / 2;
        return minRoot >= 1;
    }

}
