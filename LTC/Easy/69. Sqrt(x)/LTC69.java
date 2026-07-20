public class LTC69 {

    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }

        int sqrtOfX = 0;
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid  = left + (right - left) / 2; // Prevent Integer Oveflow (Not Use (left + right) / 2)

            if(mid <= x / mid) { // Prevent Integer Oveflow (Not Use mid * mid)
                sqrtOfX = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return sqrtOfX;
    }

}
