//import java.util.*;

public class LTC38 {
    public String countAndSay(int n) {
        // Base Case: countAndSay(1) = "1"
        if(n == 1) {
            return "1";
        }

        // Initial String Setting. Value at n = 1.
        // countAndSay(n): run-length encoding of countAndSay(n - 1)
        String result = "1";
        StringBuilder sb;
        for(int i = 2; i <= n; i++) {
            sb = new StringBuilder();

            // Using Two Pointer Concept
            int len = result.length();
            int j = 0;
            while(j < len) {
                char currentCharacter = result.charAt(j);
                int sequenceCount = 0;

                while(j < len && currentCharacter == result.charAt(j)) {
                    sequenceCount++;
                    j++;
                }

                sb.append(sequenceCount).append(currentCharacter);
            }

            result = sb.toString();
        }

        return result;
    }

//    // Global Cache: Stored Computed Result for Memoization
//    private static final Map<Integer, String> memo = new HashMap<>();
//
//    // Base Case: CountAndSay(1) = "1"
//    static {
//        memo.put(1, "1");
//    }
//
//    public String countAndSay(int n) {
//        // If n is already cached, return the result immediately
//        if(memo.containsKey(n)) {
//            return memo.get(n);
//        }
//
//        // Initial String Setting.
//        // Find the maximum(= largest, biggest) cached index smaller than current n.
//        // It means most recent pre-computed point.
//        // countAndSay(n): run-length encoding of countAndSay(n - 1)
//        int startN = n - 1;
//        while(startN > 1 && !memo.containsKey(startN)) {
//            startN--;
//        }
//
//        String result = memo.get(startN);
//
//        StringBuilder sb;
//        for(int i = startN + 1; i <= n; i++) {
//            sb = new StringBuilder();
//
//            // Using Two Pointer Concept
//            int len = result.length();
//            int j = 0;
//            while(j < len) {
//                char currentCharacter = result.charAt(j);
//                int startJ = j;
//
//                while(j < len && currentCharacter == result.charAt(j)) {
//                    j++;
//                }
//
//                int sequenceCount = j - startJ;
//
//                sb.append(sequenceCount).append(currentCharacter);
//            }
//
//            result = sb.toString();
//        }
//
//        return result;
//    }
}
