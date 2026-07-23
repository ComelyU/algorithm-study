import java.util.*;

public class LTC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sorting for Pruning
        Arrays.sort(candidates);

        // Backtracking
        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        // Base Case: remain is 0. It means sum equals target.
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));

            return;
        }

        // Prevent Duplicate Combination.(Using Start Index)
        for(int i = start; i < candidates.length; i++) {
            // Pruning: now number bigger than remain
            // -> After This Number also bigger than remain. So stop loop.
            if(candidates[i] > remain) {
                break;
            }

            currentList.add(candidates[i]);

            backtrack(result, currentList, candidates, remain - candidates[i], i);

            // backtrack
            currentList.remove(currentList.size() - 1);
        }
    }
}
