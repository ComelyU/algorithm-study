import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1954 {

    // 시계 방향: 우하좌상
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[N][N];

            int r = 0;
            int c = 0;
            int dir = 0; // 초기 방향: 오른쪽

            for (int num = 1; num <= N * N; num++) {
                grid[r][c] = num;

                int nr = r + DR[dir];
                int nc = c + DC[dir];

                // 배열 범위를 벗어나거나 이미 숫자가 채워진 경우 시계 방향으로 90도 회전
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] != 0) {
                    dir = (dir + 1) % 4;
                    nr = r + DR[dir];
                    nc = c + DC[dir];
                }

                r = nr;
                c = nc;
            }

            sb.append('#').append(tc).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(grid[i][j]).append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

}
