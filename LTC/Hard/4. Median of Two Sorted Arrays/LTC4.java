public class LTC4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always keep the length of nums1 smaller than nums2 (Ensured O(log (m+n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            // X is for nums1, Y is for nums2
            // Num of elements to Left of the partition point
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Handle edge cases using MIN/MAX values for X(nums1) partition
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1]; // no nums1 element before the partition point
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX]; // all nums1 elements before the partition point

            // Handle edge cases using MIN/MAX values for Y(nums2) partition
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1]; // no nums2 element before the partition point
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY]; // all nums2 elements before the partition point

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // Correct Partition Point Found
                if ((m + n) % 2 == 0) { // Total number of elements in both arrays is even
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else { // Total number of elements in both arrays is odd
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // Partition Point is on the right side of X(nums1)
                high = partitionX - 1;
            } else { // Partition Point is on the left side of X(nums1)
                low = partitionX + 1;
            }
        }

        // This line will never be reached, but it's necessary to satisfy the method signature.
        // cf. The problem condition
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

}
