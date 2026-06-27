import java.util.*;

public class PGM49191 {
//    // BFS 풀이
//    public int solution(int n, int[][] results) {
//        List<List<Integer>> winList = new ArrayList<>();
//        List<List<Integer>> loseList = new ArrayList<>();
//
//        for(int i = 0; i <= n; i++) {
//            winList.add(new ArrayList<>());
//            loseList.add(new ArrayList<>());
//        }
//
//        for(int[] result : results) {
//            int winner = result[0];
//            int loser = result[1];
//
//            winList.get(winner).add(loser);
//            loseList.get(loser).add(winner);
//        }
//
//        int answer = 0;
//        boolean[] visited = new boolean[n + 1];
//        for(int i = 1; i <= n; i++) {
//            Arrays.fill(visited, false);
//            int winCount = bfs(winList, i, visited);
//
//            Arrays.fill(visited, false);
//            int loseCount = bfs(loseList, i, visited);
//
//            if(winCount + loseCount == n - 1) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    private static int bfs(List<List<Integer>> adjList, int playerNum, boolean[] visited) {
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        queue.offer(playerNum);
//        visited[playerNum] = true;
//
//        int count = 0;
//        while(!queue.isEmpty()) {
//            int currentPlayer = queue.poll();
//
//            for(int nextPlayer : adjList.get(currentPlayer)) {
//                if(!visited[nextPlayer]) {
//                    queue.offer(nextPlayer);
//                    visited[nextPlayer] = true;
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    // 플로이드-워셜 풀이
    public int solution(int n, int[][] results) {
        int[][] adjArray = new int[n + 1][n + 1];

        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            adjArray[winner][loser] = 1;
            adjArray[loser][winner] = -1;
        }

        floydWarshall(n, adjArray);

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0; // 현 선수와 승부 결과를 알고 있는 선수의 수
            for(int j = 1; j <= n; j++) {
                if(adjArray[i][j] != 0) {
                    count++;
                }
            }

            if(count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private static void floydWarshall(int n, int[][] adjArray) {
        for(int k = 1; k <= n; k++) { // 중
            for(int i = 1; i <= n; i++) { // 전
                for(int j = 1; j <= n; j++) { // 후
                    // (i vs k: i win) + (k vs j: k win) 이면
                    // i vs j: i win 이 됨
                    if(adjArray[i][k] == 1 && adjArray[k][j] == 1) {
                        adjArray[i][j] = 1;
                        adjArray[j][i] = -1;
                    }
                }
            }
        }
    }

}
