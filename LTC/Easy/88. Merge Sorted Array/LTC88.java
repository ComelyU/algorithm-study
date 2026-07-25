public class LTC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the last valid elements(positions) in each array
        int i = m - 1;
        int j = n - 1;

        // Pointer for the last element(position) in nums1 array
        int k = m + n - 1;

        // Loop while exists elements to compare in both arrays
        while (i >= 0 && j >= 0) {
            // Place the larger(bigger) value at the back of nums1(= position k)
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements of nums2 to the front of nums1
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

}
