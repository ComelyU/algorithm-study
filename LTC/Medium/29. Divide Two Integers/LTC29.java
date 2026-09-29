public class LTC29 {

    public int divide(int dividend, int divisor) {
        // Exception handling for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Prevent Overflow
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long quotient = 0;

        while (dividendLong >= divisorLong) {
            long multiple = 1;
            long tempDivisor = divisorLong;

            while (dividendLong >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            dividendLong -= tempDivisor;
            quotient += multiple;
        }

        return isNegative ? (int) -quotient : (int) quotient;
    }

}
