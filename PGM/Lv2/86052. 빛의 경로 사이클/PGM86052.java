import java.util.*;

public class PGM86052 {
    // 상하좌우의 경우 방향 전환에서 하드코딩 해야함. 따라서 연속적인 회전 방향으로 (시계 방향)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static boolean[][][] visited;
    private static int ROW;
    private static int COL;

    public int[] solution(String[] grid) {
        ROW = grid.length;
        COL = grid[0].length();

        // String[] to char[][]
        char[][] gridMap = new char[ROW][COL];
        for(int y = 0; y < ROW; y++) {
            gridMap[y] = grid[y].toCharArray();
        }

        // 행, 열, 방향에 따른 방문 여부 체크
        visited = new boolean[ROW][COL][4];

        ArrayList<Integer> pathCycleLengthList = new ArrayList<>();

        for(int y = 0; y < ROW; y++) {
            for(int x = 0; x < COL; x++) {
                for(int direction = 0; direction < 4; direction++) {
                    if(!visited[y][x][direction]) {
                        pathCycleLengthList.add(shootTheLight(gridMap, y, x, direction));
                    }
                }
            }
        }

        Collections.sort(pathCycleLengthList);

//        return pathCycleLengthList.stream().mapToInt(Integer::intValue).toArray();

        int[] answer = new int[pathCycleLengthList.size()];
        for(int i = 0; i < pathCycleLengthList.size(); i++) {
            answer[i] = pathCycleLengthList.get(i);
        }

        return answer;
    }

    private static int shootTheLight(char[][] gridMap, int row, int col, int direction) {
        int length = 0;

        // 이미 방문한 경로인 경우 사이클 완료
        while (!visited[row][col][direction]) {
            visited[row][col][direction] = true;
            length++;

            // 방향 전환
            char currentBlock = gridMap[row][col];
            if (currentBlock == 'L') {
                direction = (direction + 3) % 4;
            } else if (currentBlock == 'R') {
                direction = (direction + 1) % 4;
            }

            // row, col 갱신 (범위를 넘으면 반대쪽으로 다시 돌아옴)
            row = (row + dy[direction] + ROW) % ROW;
            col = (col + dx[direction] + COL) % COL;
        }

        return length;
    }

}
