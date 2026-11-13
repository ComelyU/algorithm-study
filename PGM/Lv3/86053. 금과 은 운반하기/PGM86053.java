public class PGM86053 {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 최솟값은 최선의 경우인 0 (금과 은 모두 0 필요)
        // 최댓값은 최악의 경우인 400_000_000_000_000 (금과 은 모두 10 ^ 9, 편도 시간 10 ^ 5, 적재량 1) = 4 * 10 ^ 14
        long left = 0;
        long right = 400_000_000_000_000L;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canDeliver(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canDeliver(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalMineral = 0;

        int cityCount = g.length;

        for (int i = 0; i < cityCount; i++) {
            long roundTripTime = 2L * t[i];
            long moveCount = time / roundTripTime;

            if (time % roundTripTime >= t[i]) {
                moveCount++;
            }

            long maxWeight = moveCount * w[i];

            totalGold += Math.min(g[i], maxWeight);
            totalSilver += Math.min(s[i], maxWeight);
            totalMineral += Math.min((long) g[i] + s[i], maxWeight);
        }

        return totalGold >= a && totalSilver >= b && totalMineral >= (long) a + b;
    }

}
