import java.util.*;

public class PGM12927 {

    // Array
    public long solution(int n, int[] works) {
        int totalWork = 0;

        for (int work : works) {
            totalWork += work;
        }

        if (totalWork <= n) {
            return 0;
        }

        Arrays.sort(works);

        int length = works.length;

        while (n > 0) {
            int maxWork = works[length - 1];

            int maxCount = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (works[i] == maxWork) {
                    maxCount++;
                } else {
                    break;
                }
            }

            if (n >= maxCount) {
                for (int i = length - 1; i >= length - maxCount; i--) {
                    works[i]--;
                }

                n -= maxCount;
            } else {
                for (int i = length - 1; i >= length - n; i--) {
                    works[i]--;
                }

                n = 0;
            }
        }

        long fatigue = 0;
        for (int work : works) {
            fatigue += (long) work * work;
        }

        return fatigue;
    }

//    // Priority Queue
//    public long solution(int n, int[] works) {
//        // Max Heap
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        int totalWork = 0;
//
//        for (int work : works) {
//            totalWork += work;
//            pq.offer(work);
//        }
//
//        if (totalWork <= n) {
//            return 0;
//        }
//
//        while (n > 0) {
//            int maxWork = pq.poll(); // 문제 조건 및 예외처리로 NullPointerException 발생 안 함.
//
//            maxWork--;
//            n--;
//            pq.offer(maxWork);
//        }
//
//        long fatigue = 0;
//        while (!pq.isEmpty()) {
//            int work = pq.poll();
//
//            fatigue += (long) work * work;
//        }
//
//        return fatigue;
//    }

}
