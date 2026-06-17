import java.util.*;

public class PGM12978 {
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>(); // 인접리스트
        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] roadInfo : road) {
            int from = roadInfo[0];
            int to = roadInfo[1];
            int distance = roadInfo[2];

            adjList.get(from).add(new Node(to, distance));
            adjList.get(to).add(new Node(from, distance));
        }

        int[] minDistance = new int[N + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[1] = 0; // 시작 마을

        dijkstra(adjList, 1, minDistance);

        int deliveryCount = 0;
        for(int i = 1; i <= N; i++) {
            if(minDistance[i] <= K) {
                deliveryCount++;
            }
        }

        return deliveryCount;
    }

    // 우선순위 큐를 이용한 다익스트라
    private static void dijkstra(ArrayList<ArrayList<Node>> adjList, int start, int[] minDistance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIdx = now.idx;
            int nowDistance = now.distance;

            if(nowDistance > minDistance[nowIdx]) {
                continue;
            }

            for(Node next : adjList.get(nowIdx)) {
                if(minDistance[nowIdx] + next.distance < minDistance[next.idx]) {
                    minDistance[next.idx] = minDistance[nowIdx] + next.distance;
                    pq.offer(new Node(next.idx, minDistance[next.idx]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
//            return this.distance - o.distance;
            return Integer.compare(this.distance, o.distance);
        }
    }

    // 이 문제는 1번 마을에 대해서만 계산하면 됨. 따라서, 다익스트라
    // 만약 모든 마을(정점, 노드)에 대해 계산해야 한다면
    // 플로이드-워셜(Floyd-Warshall) 알고리즘 사용 또는 모든 정점에 대해 다익스트라.
    public int solution2(int N, int[][] road, int K) {
        int[][] minDistance = new int[N + 1][N + 1];
        int maxDistance = 500_001; // 도로 길이 최대 10_000 * 마을 수 최대 50 + 1

        for(int i = 1; i <= N; i++) {
            Arrays.fill(minDistance[i], maxDistance);
            minDistance[i][i] = 0; // 같은 마을 내에서는 0
        }

        for(int[] roadInfo : road) {
            int from = roadInfo[0];
            int to = roadInfo[1];
            int distance = roadInfo[2];

            if(minDistance[from][to] > distance) {
                minDistance[from][to] = distance;
                minDistance[to][from] = distance;
            }
        }

        floydWarshall(minDistance, N);

        int deliveryCount = 0;
        for(int i = 1; i <= N; i++) {
            if(minDistance[1][i] <= K) {
                deliveryCount++;
            }
        }

        return deliveryCount;
    }

    // 플로이드-워셜 알고리즘
    // 거쳐가는 마을(노드, 정점)이 k
    private static void floydWarshall(int[][] minDistance, int N) {
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(minDistance[i][k] + minDistance[k][j] < minDistance[i][j]) {
                        minDistance[i][j] = minDistance[i][k] + minDistance[k][j];
                    }
//                    minDistance[i][j] = Math.min(minDistance[i][j], minDistance[i][k] + minDistance[k][j]);
                }
            }
        }
    }
}
