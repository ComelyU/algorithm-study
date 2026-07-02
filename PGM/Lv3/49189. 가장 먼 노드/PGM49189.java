import java.util.*;

public class PGM49189 {

    public int solution(int n, int[][] edge) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edgeInfo : edge) {
            int from = edgeInfo[0];
            int to = edgeInfo[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        bfs(1, adjList, distances, visited);

        int maxDistance = 0;
        int count = 0;
        for(int distance : distances) {
            if(distance > maxDistance) {
                maxDistance = distance;
                count = 1;
            } else if(distance == maxDistance) {
                count++;
            }
        }

        return count;
    }

    private static void bfs(int startNode, List<List<Integer>> adjList, int[] distances, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            for(int nextNode : adjList.get(currentNode)) {
                if(!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                    distances[nextNode] = distances[currentNode] + 1;
                }
            }
        }
    }
}
