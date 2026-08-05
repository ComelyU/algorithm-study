import java.util.*;

public class PGM147354 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
//        Arrays.sort(data, Comparator.<int[], Integer>comparing(o -> o[col - 1])
//            .thenComparing(o -> o[0], Comparator.reverseOrder()));

//        Arrays.sort(data, Comparator.comparingInt((int[] o) -> o[col -1])
//            .thenComparingInt(o -> -o[0]));

        Arrays.sort(data, Comparator.comparingInt((int[] o) -> o[col -1])
            .thenComparing(o -> o[0], Comparator.reverseOrder()));

//        Arrays.sort(data, (o1, o2) -> {
//            if (o1[col - 1] == o2[col - 1]) {
//                return Integer.compare(o2[0], o1[0]);
//            }
//
//            return Integer.compare(o1[col - 1], o2[col - 1]);
//        });

        int answerHash = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;

            for (int value : data[i - 1]) {
                sum += (value % i);
            }

            answerHash ^= sum;
        }

        return answerHash;
    }

}
