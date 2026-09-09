import java.util.*;

public class PGM76503 {

    private static long actionCount = 0;
    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private static long[] weights;
    private static int[] degrees;

    public long solution(int[] a, int[][] edges) {
        long weightSum = 0;
        weights = new long[a.length];
        degrees = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            weights[i] = a[i];
            weightSum += a[i];
        }

        // 전체 가중치의 합이 0이 아니면 모두 0으로 만들기 불가능
        if (weightSum != 0) {
            return -1;
        }

        // 노드가 2개뿐인 경우
        if (a.length == 2) {
            return Math.abs(a[0]);
        }

        // 인접 리스트 및 진입 차수(degree) 초기화
        for (int i = 0; i < a.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);

            degrees[u]++;
            degrees[v]++;
        }

        // 위상 정렬(Topology Sort) 기반의 가중치 모으기 (진입 차수(degree) 이용)
        // 위상 정렬로 트리 깎기
        topologySort(a.length);

        return actionCount;
    }

    // 리프 노드부터 탐색하여 가중치를 부모 노드로 모으고 연산 횟수 누적
    private static void topologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        // 리프 노드 큐에 삽입
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
            }
        }

        // 하향식 위상 정렬, 상향식 트리 정리
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            for (int nextNode : adjList.get(currentNode)) {
                if (!visited[nextNode]) {
                    // 현 리프 노드의 가중치를 연결된 부모 노드에 전달
                    weights[nextNode] += weights[currentNode];
                    actionCount += Math.abs(weights[currentNode]);

                    // 간선 제거에 따른 부모 노드의 진입 차수 감소
                    degrees[nextNode]--;

                    // 부모 노드가 새로운 리프 노드가 된 경우
                    if (degrees[nextNode] == 1) {
                        queue.offer(nextNode);
                    }

                    // 탐색 노드가 리프 노드. 더 이상 다른 연결 검사 필요 없음.
                    break;
                }
            }
        }
    }

}

//public class PGM76503 { // DFS. 일부 테케 런타임 에러 (스택오버플로우 추정)
//
//    private static long actionCount = 0;
//    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//    private static long[] weights;
//
//    public long solution(int[] a, int[][] edges) {
//        long weightSum = 0;
//        weights = new long[a.length];
//
//        for (int i = 0; i < a.length; i++) {
//            weights[i] = a[i];
//            weightSum += a[i];
//        }
//
//        if (weightSum != 0) {
//            return -1;
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//
//            adjList.get(u).add(v);
//            adjList.get(v).add(u);
//        }
//
//        dfs(0, -1);
//
//        return actionCount;
//    }
//
//    private static void dfs(int currentNode, int parentNode) {
//        for (int nextNode : adjList.get(currentNode)) {
//            if (nextNode != parentNode) {
//                dfs(nextNode, currentNode);
//            }
//        }
//
//        if (parentNode != -1) {
//            weights[parentNode] += weights[currentNode];
//        }
//
//        actionCount += Math.abs(weights[currentNode]);
//        weights[currentNode] = 0;
//    }
//}
