import java.util.*;
import java.util.stream.*;

public class PGM87390 {
    public int[] solution(int n, long left, long right) {
//        return LongStream.rangeClosed(left, right)
//            .mapToInt(i -> (int) (Math.max(i / n, i % n) + 1))
//            .toArray();

        int[] answer = new int[(int) (right - left + 1)];

        // 2차원 배열을 1차원 배열로 생각해서 풀이. (행은 몫, 열은 나머지)
        // 2차원 배열 상에서 i행 j열의 값은 i, j 중 큰 값 + 1
        for(long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            answer[(int) (i - left)] = (int) (Math.max(row, col) + 1);
        }

        return answer;
    }
}
