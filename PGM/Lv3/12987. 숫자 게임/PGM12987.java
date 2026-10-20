import java.util.*;

public class PGM12987 {

    // 배열 풀이 (우선순위 큐 사용하는 풀이도 가능)
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int bScore = 0;

        for (int bIndex = 0; bIndex < B.length; bIndex++) {
            if (B[bIndex] > A[aIndex]) {
                bScore++;
                aIndex++;
            }
        }

        return bScore;
    }

}
