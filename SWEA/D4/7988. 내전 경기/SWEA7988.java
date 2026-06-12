import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA7988 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int K = Integer.parseInt(br.readLine());

            HashMap<String, Integer> playerMap = new HashMap<>();
            int playerNum = 0;
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(2 * K);
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String playerAlphaName = st.nextToken();
                String playerBetaName = st.nextToken();

                if(!playerMap.containsKey(playerAlphaName)) {
                    playerMap.put(playerAlphaName, playerNum++);
                    adjList.add(new ArrayList<>());
                }
                if(!playerMap.containsKey(playerBetaName)) {
                    playerMap.put(playerBetaName, playerNum++);
                    adjList.add(new ArrayList<>());
                }

                int playerAlphaIndex = playerMap.get(playerAlphaName);
                int playerBetaIndex = playerMap.get(playerBetaName);

                adjList.get(playerAlphaIndex).add(playerBetaIndex);
                adjList.get(playerBetaIndex).add(playerAlphaIndex);
            }

            sb.append('#').append(testCase).append(' ').append(isBipartite(playerNum, adjList) ? "Yes" : "No").append('\n');

        }

        System.out.println(sb.toString());
    }

    // 이분 그래프(Bipartite Graph) 판별
    // 모든 꼭짓점을 두 개의 그룹으로 나누었을 때, 모든 변이 서로 다른 그룹의 꼭짓점들을 연결하도록 분할할 수 있는 그래프
    // 즉, 같은 그룹에 속한 정점끼리는 직접 연결된 간선이 전혀 없는 그래프
    private static boolean isBipartite(int playerNum, ArrayList<ArrayList<Integer>> adjList) {
        int[] teamColor = new int[playerNum]; // 0: 미지정, 1: teamA, -1: teamB

        for(int i = 0; i < playerNum; i++) {
            if(teamColor[i] == 0) {
                if(!checkTeamByBFS(i, teamColor, adjList)) { // 하나라도 이분 그래프 조건을 만족하지 않으면
                    return false;
                }

//                if(!checkTeamByDFS(i, 1, teamColor, adjList)) {
//                    return false;
//                }
            }
        }

        return true;
    }

    // BFS를 통해 인접 정점(노드)을 다른 팀으로 지정
    private static boolean checkTeamByBFS(int startNode, int[] teamColor, ArrayList<ArrayList<Integer>> adjList) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(teamColor.length); // 큐에 최대 teamColor.length(== playerNum)개의 정점이 들어감.

        queue.offer(startNode);
        teamColor[startNode] = 1;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            for(int nextNode : adjList.get(currentNode)) {
                if(teamColor[nextNode] == 0) {
                    teamColor[nextNode] = -teamColor[currentNode];
                    queue.offer(nextNode);
                } else if(teamColor[nextNode] == teamColor[currentNode]) { // 인접 노드가 이미 같은 팀으로 칠해져 있다면 이분 그래프가 아님
                    return false;
                }
            }
        }

        return true;
    }

    // DFS를 통해 인접 노드를 다른 팀으로 재귀적 지정
    private static boolean checkTeamByDFS(int currentNode, int color, int[] teamColor, ArrayList<ArrayList<Integer>> adjList) {
        teamColor[currentNode] = color; // 현재 노드 팀 지정

        for(int nextNode : adjList.get(currentNode)) {
            if(teamColor[nextNode] == 0) {
                // 인접 노드가 미지정 상태라면 반대 팀(-color)으로 지정하여 재귀 호출
                if(!checkTeamByDFS(nextNode, -color, teamColor, adjList)) {
                    return false;
                }
            } else if(teamColor[nextNode] == teamColor[currentNode]) {
                // 인접 노드가 이미 같은 팀으로 칠해져 있다면 이분 그래프가 아님
                return false;
            }
        }

        return true;
    }
}
