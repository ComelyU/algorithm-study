import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1428 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int minSum = Integer.MAX_VALUE;

        int xCondition = W / A;
        for (int x = 0; x <= xCondition; x++) {
            int firstRemain = W - (A * x);
            int yCondition = firstRemain / B;
            for (int y = 0; y <= yCondition; y++) {
                int secondRemain = firstRemain - (B * y);

                if (secondRemain % C == 0) {
                    int z = secondRemain / C;

                    int currentSum = x + y + z;

                    if (currentSum < minSum) {
                        minSum = currentSum;
                    }
                }
            }
        }

        System.out.println(minSum);
    }

}
