import java.util.*;

public class PGM86971 {
    private static int totalNode;
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int minNodeDiff;

    public int solution(int n, int[][] wires) {
        totalNode = n;
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        minNodeDiff = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }

        // 특정 노드를 루트로 삼아 dfs를 1번만 함. (1번 노드 아니어도 됨).
        // 모든 전선을 끊어보면 O(n^2)이지만 dfs 1번 안에서 서브 트리를 이용해 끊었다고 가정하면 O(n)
        dfs(1);

        return minNodeDiff;
    }

    // 특정 노드를 루트 노드로 하는 서브 트리의 노드 개수 반환
    private int dfs(int node) {
        visited[node] = true;

        int subTreeSize = 1; // 자기 자신을 포함한 서브 트리의 노드 수
        for(int nextNode : tree[node]) {
            if(!visited[nextNode]) {
                // 재귀를 통해 자식 노드의 서브 트리 노드 수 합산
                int childSubTreeSize = dfs(nextNode);
                subTreeSize += childSubTreeSize;

                // node - next 사이의 전선을 끊었다고 가정. 두 전력망의 송전탑 개수 차이
                int diff = Math.abs(childSubTreeSize - (totalNode - childSubTreeSize));
                minNodeDiff = Math.min(minNodeDiff, diff);
            }
        }

        return subTreeSize;
    }

}
