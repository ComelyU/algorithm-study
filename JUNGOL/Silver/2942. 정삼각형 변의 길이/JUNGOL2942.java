import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL2942 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100

        // 파도반 수열의 점화식 P(n)은 P(0) = P(1) = P(2) = 1, P(n) = P(n - 2) + P(n - 3)
        // 다만, 이 문제에서는 p(1)부터 시작.
        // P(1) = P(2) = P(3) = 1, P(n) = P(n - 2) + P(n - 3)

        // 또 다른 점화식으로는 P(0) = P(1) = P(2) = 1, P(3) = P(4) = 2, P(n) = P(n - 1) + P(n - 5)

        if (N <= 3) {
            System.out.println(1);
            return;
        }

//        long[] P = new long[N + 1];
//        P[1] = P[2] = P[3] = 1;
//
//        for (int i = 4; i <= N; i++) {
//            P[i] = P[i - 2] + P[i - 3];
//        }
//
//        System.out.println(P[N]);

        long p1 = 1;
        long p2 = 1;
        long p3 = 1;
        long pCurrent = 0;

        for (int i = 4; i <= N; i++) {
            pCurrent = p2 + p1; // p(i - 2) + p(i - 3)
            p1 = p2;
            p2 = p3;
            p3 = pCurrent;
        }

        System.out.println(pCurrent);
    }

}
