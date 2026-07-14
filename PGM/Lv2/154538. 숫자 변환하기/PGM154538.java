import java.util.*;

public class PGM154538 {

    // DP
    public int solution(int x, int y, int n) {
        if(x == y) {
            return 0;
        }

        return calculateDP(x, y, n);
    }

    private int calculateDP(int start, int target, int unit) {
        int[] dp = new int[target + 1]; // dp[i]: start에서 i를 만들기 위한 최소 연산 횟수

        final int INF = Integer.MAX_VALUE; // target + 1 도 가능.
        Arrays.fill(dp, INF); // 초기값을 도달 불가능을 의미하는 값으로 설정
        dp[start] = 0; // 시작값 연산 횟수 0

//        for(int i = start + 1; i <= target; i++) {
//            int minCount = INF;
//
//            // i - unit이 가능한 값이고 그 전 단계의 연산 횟수가 유효한 값
//            if(i - unit >= start && dp[i - unit] != INF) {
//                minCount = Math.min(minCount, dp[i - unit] + 1);
//            }
//
//            // i가 2로 나누어 떨어져 i / 2 가 가능한 값이고 그 전 단계의 연산 횟수가 유효한 값
//            if(i % 2 == 0 && i / 2 >= start && dp[i / 2] != INF) {
//                minCount = Math.min(minCount, dp[i / 2] + 1);
//            }
//
//            // i가 3으로 나누어 떨어져 i / 3 가 가능한 값이고 그 전 단계의 연산 횟수가 유효한 값
//            if(i % 3 == 0 && i / 3 >= start && dp[i / 3] != INF) {
//                minCount = Math.min(minCount, dp[i / 3] + 1);
//            }
//
//            dp[i] = minCount;
//        }
//
//        return dp[target] == INF ? -1 : dp[target];

        for(int i = start; i <= target; i++) {
            if(dp[i] == INF) { // 현재 숫자에 도달 불가능한 경우 스킵
                continue;
            }

            if(i + unit <= target) {
                dp[i + unit] = Math.min(dp[i + unit], dp[i] + 1);
            }
            if(i * 2 <= target) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if(i * 3 <= target) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[target] == INF ? -1 : dp[target];
    }

//    // BFS
//    public int solution(int x, int y, int n) {
//        if(x == y) {
//            return 0;
//        }
//
//        return bfs(x, y, n);
//    }
//
//    private int bfs(int start, int target, int unit) {
//        boolean[] visited = new boolean[target + 1];
//        Queue<int[]> queue = new ArrayDeque<>(); // int[0]: value, int[1]: count(depth)
//
//        queue.offer(new int[] {start, 0});
//        visited[start] = true;
//
//        while(!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int currentValue = current[0];
//            int currentCount = current[1];
//
//            int[] nextValues = {currentValue + unit, currentValue * 2, currentValue * 3};
//
//            for(int nextValue : nextValues) {
//                if(nextValue == target) {
//                    return currentCount + 1;
//                }
//
//                if(nextValue < target && !visited[nextValue]) {
//                    queue.offer(new int[] {nextValue, currentCount + 1});
//                    visited[nextValue] = true;
//                }
//            }
//        }
//
//        return -1; // y 만들기 불가능
//    }

}
