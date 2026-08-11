import java.util.*;

public class PGM138477 {

    public int[] solution(int k, int[] score) {
        // 우선순위 큐(Priority Queue)를 최소 힙(Min Heap)으로
        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>();

        int[] lowestRankScores = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            pqMinHeap.offer(score[i]);

            if (pqMinHeap.size() > k) {
                pqMinHeap.poll();
            }

            lowestRankScores[i] = pqMinHeap.peek();
        }

        return lowestRankScores;
    }

}
