import java.util.*;

public class PGM142085 {

    // Priority Queue
    public int solution(int n, int k, int[] enemy) {
        // 우선순위 큐(Priority Queue)를 최대 힙(Max Heap)으로
        PriorityQueue<Integer> pqMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int maxDefenseRound = 0;

        for (int i = 0; i < enemy.length; i++) {
            int nowEnemy = enemy[i];

            n -= nowEnemy;
            pqMaxHeap.offer(nowEnemy);

            if (n < 0) {
                if (k > 0) {
                    n += pqMaxHeap.poll();
                    k--;
                } else {
                    break;
                }
            }

            maxDefenseRound++;
        }

        return maxDefenseRound;
    }

//    // Binary Search
//    public int solution(int n, int k, int[] enemy) {
//        int maxDefenseRound = 0;
//        int left = 0;
//        int right = enemy.length;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2; // 오버플로우 발생하지 않는 범위라 (left + right) / 2 도 가능
//
//            if (canDefend(n, k, mid, enemy)) {
//                maxDefenseRound = mid;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return maxDefenseRound;
//    }
//
//    private boolean canDefend(int n, int k, int mid, int[] enemy) {
//        // 무적권(k)이 방어해야 하는 라운드(mid)보다 많은 경우 무조건 생존 가능
//        if (k >= mid) {
//            return true;
//        }
//
//        // 0부터 mid - 1 까지의 적의 수를 복사 및 오름차순 정렬
//        int[] slicedEnemy = Arrays.copyOfRange(enemy, 0, mid);
//        Arrays.sort(slicedEnemy);
//
//        // 무적권을 우선 사용 후 남은 라운드에 대해 적의 수 총합을 구함
//        // 오름차순 정렬되어 있어 끝에서 k개의 라운드의 경우 범위에서 제외
//        long enemySum = 0;
//        for (int i = 0; i < mid - k; i++) {
//            enemySum += slicedEnemy[i];
//        }
//
//        return enemySum <= n;
//    }

}
