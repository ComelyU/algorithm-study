public class PGM43162 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int networkCount = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, visited, n, computers);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void dfs(int node, boolean[] visited, int n, int[][] computers) {
        visited[node] = true;

        for(int nextNode = 0; nextNode < n; nextNode++) {
            if(computers[node][nextNode] == 1 && !visited[nextNode]) {
                dfs(nextNode, visited, n, computers);
            }
        }
    }

}
