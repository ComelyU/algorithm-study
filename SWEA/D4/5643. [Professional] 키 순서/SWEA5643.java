import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {

    // Floyd-Warshall
    private static int N, M;
    private static boolean[][] adjMatrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());

            adjMatrix = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjMatrix[a][b] = true; // a보다 b의 키가 큼
            }

            floydWarshall();

            sb.append('#').append(testCase).append(' ')
                .append(countKnownRanks()).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) { // 경유
            for (int i = 1; i <= N; i++) { // 출발
                for (int j = 1; j <= N; j++) { // 도착
                    if (adjMatrix[i][k] && adjMatrix[k][j]) {
                        adjMatrix[i][j] = true;
                    }
                }
            }
        }
    }

    private static int countKnownRanks() {
        final int MAX_RELATION_COUNT = N - 1;
        int knownRankCount = 0;

        for (int i = 1; i <= N; i++) {
            int relationCount = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (adjMatrix[i][j] || adjMatrix[j][i]) {
                    relationCount++;
                }
            }

            if (relationCount == MAX_RELATION_COUNT) {
                knownRankCount++;
            }
        }

        return knownRankCount;
    }

//    // BFS
//    private static int N, M;
//    private static List<List<Integer>> adjList, reverseAdjList; // 정방향: 나보다 큰 리스트, 역방향: 나보다 작은 리스트
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine().trim());
//        for (int testCase = 1; testCase <= T; testCase++) {
//            N = Integer.parseInt(br.readLine().trim());
//            M = Integer.parseInt(br.readLine().trim());
//
//            adjList = new ArrayList<>(N + 1);
//            reverseAdjList = new ArrayList<>(N + 1);
//
//            for (int i = 0; i <= N; i++) {
//                adjList.add(new ArrayList<>());
//                reverseAdjList.add(new ArrayList<>());
//            }
//
//            for (int i = 0; i < M; i++) {
//                st = new StringTokenizer(br.readLine());
//
//                int a = Integer.parseInt(st.nextToken());
//                int b = Integer.parseInt(st.nextToken());
//
//                adjList.get(a).add(b); // 정방향
//                reverseAdjList.get(b).add(a); // 역방향
//            }
//
//            sb.append('#').append(testCase).append(' ')
//                .append(countKnownRanksByBFS()).append('\n');
//        }
//
//        System.out.println(sb.toString());
//    }
//
//    private static int bfs(int start, List<List<Integer>> list) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        boolean[] visited = new boolean[N + 1];
//
//        queue.offer(start);
//        visited[start] = true;
//
//        int count = 0;
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//
//            for (int next : list.get(current)) {
//                if (!visited[next]) {
//                    visited[next] = true;
//                    count++;
//                    queue.offer(next);
//                }
//            }
//        }
//
//        return count;
//    }
//
//    private static int countKnownRanksByBFS() {
//        final int MAX_RELATION_COUNT = N - 1;
//        int knownRankCount = 0;
//
//        for (int i = 1; i <= N; i++) {
//            int tallerCount = bfs(i, adjList);
//            int shorterCount = bfs(i, reverseAdjList);
//
//            if (tallerCount + shorterCount == MAX_RELATION_COUNT) {
//                knownRankCount++;
//            }
//        }
//
//        return knownRankCount;
//    }

}
