import java.util.*;

public class LTC17 {

    private static final String[] KEYPAD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Backtracking DFS
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) { // Constraints: 1 <= digits.length <= 4. So Always false.
            return result;
        }

        backtrack(result, digits, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder currentCombination) {
        // Base Case: index == digits.length()
        if (index == digits.length()) {
            result.add(currentCombination.toString());

            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

//        for (int i = 0; i < letters.length(); i++) {
//            currentCombination.append(letters.charAt(i));
//            backtrack(result, digits, index + 1, currentCombination);
//            currentCombination.deleteCharAt(currentCombination.length() - 1);
//        }

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(result, digits, index + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

//    // BFS
//    public List<String> letterCombinations(String digits) {
//        Queue<String> queue = new ArrayDeque<>();
//
//        if (digits == null || digits.isEmpty()) { // Constraints: 1 <= digits.length <= 4. So Always false.
//            return new ArrayList<>();
//        }
//
//        queue.offer("");
//
//        for (int i = 0; i < digits.length(); i++) {
//            int digit = digits.charAt(i) - '0';
//            char[] letters = KEYPAD[digit].toCharArray();
//
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                String current = queue.poll();
//
//                for (char letter : letters) {
//                    queue.offer(current + letter);
//                }
//            }
//        }
//
//        return new ArrayList<>(queue);
//    }

}
