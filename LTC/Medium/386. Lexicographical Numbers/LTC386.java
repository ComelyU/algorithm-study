import java.util.*;

public class LTC386 {

    // Approach: Iterative Traversal on an Implicit Denary Trie (O(1) Space)
    // Concept: Simulating Trie Preorder Traversal using Math Operations
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        int currentNum = 1;

        for (int i = 0; i < n; i++) {
            result.add(currentNum);

            if (currentNum * 10 <= n) {
                // Move to the first child (e.g., 1 -> 10)
                currentNum *= 10;
            } else {
                // Backtrack if at the end of a level (ends with 9) or exceeds n
                while (currentNum % 10 == 9 || currentNum + 1 > n) {
                    currentNum /= 10;
                }

                // Move to the next sibling (e.g., 10 -> 11, 19 -> 2)
                currentNum++;
            }
        }

        return result;
    }

}
