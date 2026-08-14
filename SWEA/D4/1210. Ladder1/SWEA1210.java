import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        final int RC_SIZE = 100;
        final int LAST_RC_INDEX = RC_SIZE - 1;

        for (int testCase = 1; testCase <= 10; testCase++) {
            br.readLine();

            int[][] ladder = new int[RC_SIZE][RC_SIZE];

            for (int i = 0; i < RC_SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < RC_SIZE; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 도착점 좌표
            int x = LAST_RC_INDEX;
            int y = 0;

            for (int i = 0; i < RC_SIZE; i++) {
                if(ladder[LAST_RC_INDEX][i] == 2) {
                    y = i;

                    break;
                }
            }

            while (x > 0) {
                if (y > 0 && ladder[x][y - 1] == 1) { // Check Left
                    while (y > 0 && ladder[x][y - 1] == 1) {
                        y--;
                    }
                } else if (y < LAST_RC_INDEX && ladder[x][y + 1] == 1) { // Check Right
                    while (y < LAST_RC_INDEX && ladder[x][y + 1] == 1) {
                        y++;
                    }
                }

                // Move Up
                x--;
            }

            sb.append('#').append(testCase).append(' ').append(y).append('\n');
        }

        System.out.println(sb.toString());
    }

}
