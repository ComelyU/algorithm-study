public class PGM87946 {
    private static int maxDungeonCount;
    private static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        maxDungeonCount = 0;
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return maxDungeonCount;
    }

    private static void dfs(int currentFatigueLevel, int[][] dungeons, int dungeonCount) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && currentFatigueLevel >= dungeons[i][0]) {
                visited[i] = true; // 가지치기

                dfs(currentFatigueLevel - dungeons[i][1], dungeons, dungeonCount + 1);

                visited[i] = false; // 백트래킹
            }
        }
        maxDungeonCount = Math.max(maxDungeonCount, dungeonCount);
    }

}
