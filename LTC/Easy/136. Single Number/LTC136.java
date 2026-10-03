public class LTC136 {

    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR bitwise properties:
        // 1. A ^ A = 0
        // 2. 0 ^ A = A
        // 3. Commutative and associative properties hold true.
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
