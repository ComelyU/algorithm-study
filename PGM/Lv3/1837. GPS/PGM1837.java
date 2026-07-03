import java.util.*;

public class PGM1837 {
    private static final int INF = 101; // k의 범위가 2 이상, 100 이하

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i); // 한 거점에 머무르는 경우
        }

        for(int[] edge : edge_list) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // dp[i][j]: i번째 이동에서 j번 거점에 도착할 경우 수정된 최소 횟수
        int[][] dp = new int[k][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // 승차 위치 초기화
        dp[0][gps_log[0]] = 0;

        // dp
        for(int i = 1; i < k; i++) { // i: 현재 이동 횟수
            for(int j = 1; j <= n; j++) { // j: 현재 가고 싶은 거점. 즉, 목적지
                int moveCost = (j == gps_log[i]) ? 0 : 1; // 목적지와 gps 로그가 같으면 수정 불필요, 다르면 수정 필요.

                List<Integer> prevList = adjList.get(j);
                for(int prev : prevList) { // prev: 목적지로 갈 수 있는 직전 거점들
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][prev] + moveCost); // 이전까지의 최소 수정 횟수 + 이번 수정 여부의 값과 비교
                }
            }
        }

        int modifyCount = dp[k - 1][gps_log[k - 1]]; // 마지막 하차 지점의 최소 수정 횟수

        return modifyCount >= INF ? -1 : modifyCount;
    }
}
