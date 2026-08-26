import java.util.*;

public class PGM43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1; // 최소 소요 시간.
        long right = (long) times[times.length - 1] * n; // 최대 소요 시간. 가장 긴 심사 시간 * 사람 수
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time; // 각 심사관이 mid 시간 동안 심사할 수 있는 사람 수
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
