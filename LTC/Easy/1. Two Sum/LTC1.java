import java.util.*;

public class LTC1 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length); // key, value = num, index

        for(int i = 0; i < length; i++) {
            int complement = target - nums[i]; // calculate complement for make target number

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // No Solution. But 'Only one valid answer exists.' in Constraints.
    }
}
