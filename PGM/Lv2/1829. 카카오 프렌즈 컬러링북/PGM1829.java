import java.util.*;

public class PGM1829 {
    // 상하좌우 이동
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++; // 새로운 영역

                    int areaSize = bfs(picture, m, n, i, j);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    private static int bfs(int[][] picture, int m, int n, int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = true;

        int color = picture[startX][startY];
        int size = 0;

        while(!queue.isEmpty()) {
            int[] currentArea = queue.poll();

            size++;

            for(int i = 0; i < 4; i++) {
                int nextX = currentArea[0] + dx[i];
                int nextY = currentArea[1] + dy[i];

                if(isValidArea(nextX, nextY, m, n)) {
                    if(!visited[nextX][nextY] && picture[nextX][nextY] == color) {
                        queue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return size;
    }

    private static boolean isValidArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
