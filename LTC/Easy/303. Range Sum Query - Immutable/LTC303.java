public class LTC303 {

    class NumArray {

        private int[] prefixSums;

        public NumArray(int[] nums) {
            prefixSums = new int[nums.length + 1];

            // prefixSums[i]: Sum of nums[0] to nums[i - 1]
            for (int i = 0; i < nums.length; i++) {
                prefixSums[i + 1] = prefixSums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            // Sum of nums[left] to nums[right]: Sum of nums[0] to nums[right] - Sum of nums[0] to nums[left - 1]
            return prefixSums[right + 1] - prefixSums[left];
        }

    }

}
