import java.util.*;

public class PGM154540 {
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int rows;
    private static int columns;

    public int[] solution(String[] maps) {
        rows = maps.length;
        columns = maps[0].length();
        visited = new boolean[rows][columns];

        List<Integer> stayDays = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
//                    stayDays.add(bfs(i, j, maps));
                    stayDays.add(dfs(i, j, maps));
                }
            }
        }

        if (stayDays.isEmpty()) {
            return new int[]{-1};
        }

        int[] answer = new int[stayDays.size()];
        for (int i = 0; i < stayDays.size(); i++) {
            answer[i] = stayDays.get(i);
        }
        Arrays.sort(answer);

        return answer;

//        return stayDays.stream().mapToInt(i -> i).sorted().toArray();
    }

    private static int bfs(int startX, int StartY, String[] maps) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startX, StartY});
        visited[startX][StartY] = true;

        int totalStayDayCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            totalStayDayCount += maps[x].charAt(y) - '0';

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (isValid(nextX, nextY, maps)) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return totalStayDayCount;
    }

    private static int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;

        int totalStayDayCount = maps[x].charAt(y) - '0';

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY, maps)) {
                totalStayDayCount += dfs(nextX, nextY, maps);
            }
        }

        return totalStayDayCount;
    }

    private static boolean isValid(int x, int y, String[] maps) {
        // 1. 맵 배열의 범위를 벗어나는지 먼저 체크 (IndexOutOfBounds 예방)
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }

        // 바다이거나 이미 방문한 곳
        if (maps[x].charAt(y) == 'X' || visited[x][y]) {
            return false;
        }

        return true;
    }

}
