import java.io.BufferedReader;
import java.util.StringTokenizer;

public class JUNGOL1733 {

    private static final int IMPOSSIBLE = 0;
    private static final int SIZE = 19;
    private static int[][] board = new int[SIZE][SIZE];
    private static final int[] dx = {-1, 0, 1, 1}; // 우상, 우, 우하, 하
    private static final int[] dy = {1, 1, 1, 0}; // 우상, 우, 우하, 하

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) { // 바둑알이 놓이지 않은 자리
                    continue;
                }

                int color = board[i][j];
                for (int d = 0; d < 4; d++) {
                    boolean flag = true;

                    // 연속적으로 여섯 알 이상인 경우 인정되지 않음
                    // 따라서, 육목이 될 수 있는 양 끝 체크하여 가지치기
                    int prevRow = i - dx[d];
                    int prevCol = j - dy[d];
                    int lastCheckRow = i + dx[d] * 5;
                    int lastCheckCol = j + dy[d] * 5;

                    if (isValid(prevRow, prevCol) && board[prevRow][prevCol] == color) {
                        continue;
                    }

                    if (isValid(lastCheckRow, lastCheckCol) && board[lastCheckRow][lastCheckCol] == color) {
                        continue;
                    }


                    // 해당 방향으로 4번 체크.
                    for (int k = 1; k <= 4; k++) {
                        int nextRow = i + dx[d] * k;
                        int nextCol = j + dy[d] * k;

                        if (!isValid(nextRow, nextCol) || board[nextRow][nextCol] != color) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        StringBuilder sb = new StringBuilder();

                        sb.append(color).append('\n')
                            .append(i + 1).append(' ').append(j + 1);

                        System.out.println(sb.toString());

                        return;
                    }
                }
            }
        }

        System.out.println(IMPOSSIBLE);
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

}
