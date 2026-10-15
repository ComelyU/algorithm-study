public class LTC50 {

    public double myPow(double x, int n) {
        long N = n; // Prevent Overflow when Integer.MIN_VALUE
        if (N < 0) {
//            x = 1 / x;
            N = -N;
        }

        double powResult = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if ((N & 1) != 0) { // N % 2 != 0
                powResult *= currentProduct;
            }

            currentProduct *= currentProduct;
            N >>= 1; // N /= 2
        }

        if (n < 0) {
            powResult = 1 / powResult;
        }

        return powResult;
    }

}
