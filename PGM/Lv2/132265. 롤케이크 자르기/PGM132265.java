import java.util.*;

public class PGM132265 {

//    // HashMap
//    public int solution(int[] topping) {
//        int answer = 0;
//
//        Map<Integer, Integer> leftMap = new HashMap<>();
//        Map<Integer, Integer> rightMap = new HashMap<>();
//
//        for (int t : topping) {
//            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
//        }
//
//        for (int t : topping) {
//            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);
//            rightMap.put(t, rightMap.get(t) - 1);
//
//            if (rightMap.get(t) == 0) {
//                rightMap.remove(t);
//            }
//
//            if (leftMap.size() == rightMap.size()) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }

    // Array
    public int solution(int[] topping) {
        int answer = 0;

        int[] left = new int[10_001];
        int[] right = new int[10_001];
        int leftSize = 0;
        int rightSize = 0;

        for (int t : topping) {
            if (right[t] == 0) {
                rightSize++;
            }

            right[t]++;
        }

        for (int t : topping) {
            if (left[t] == 0) {
                leftSize++;
            }

            left[t]++;
            right[t]--;

            if (right[t] == 0) {
                rightSize--;
            }

            if (leftSize == rightSize) {
                answer++;
            }
        }

        return answer;
    }

}
