import java.util.*;

// Next Permutation
public class LTC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        Arrays.sort(nums);

        do {
//            permutations.add(new ArrayList<>(Arrays.stream(nums).boxed().toList()));
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            permutations.add(permutation);
        } while (findNextPermutation(nums));

        return permutations;
    }

    private static boolean findNextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }

        swap(nums, i - 1, j);

        int k = nums.length - 1;
        while (i < k) {
            swap(nums, i++, k--);
        }

        return true;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//// DFS with Backtracking
//public class LTC46 {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> permutations = new ArrayList<>();
//        boolean[] visited = new boolean[nums.length];
//
//        // Essential when:
//        // 1. Results must be in lexicographical order.
//        // 2. Duplicated elements exist (for pruning/skipping duplicates).
//        Arrays.sort(nums);
//
//        dfsWithBacktracking(permutations, new ArrayList<>(), nums, visited);
//
//        return permutations;
//    }
//
//    private static void dfsWithBacktracking(List<List<Integer>> permutations, List<Integer> nowPermutation, int[] nums, boolean[] visited) {
//        if (nowPermutation.size() == nums.length) {
//            permutations.add(new ArrayList<>(nowPermutation));
//
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i]) {
//                continue;
//            }
//
//            visited[i] = true;
//            nowPermutation.add(nums[i]);
//
//            dfsWithBacktracking(permutations, nowPermutation, nums, visited);
//
//            visited[i] = false;
//            nowPermutation.remove(nowPermutation.size() - 1);
//        }
//    }
//}
