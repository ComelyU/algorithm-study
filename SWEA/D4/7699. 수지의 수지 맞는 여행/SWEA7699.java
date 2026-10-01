import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA7699 {

    private final static int[] dr = {-1, 1, 0, 0};
    private final static int[] dc = {0, 0, -1, 1};
    private final static int A_TO_Z = 26;

    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[] visited = new boolean[A_TO_Z];
    private static int maxSpecialityCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }

            Arrays.fill(visited, false);
            maxSpecialityCount = 0;

            int startAlphabet = map[0][0] - 'A';
            visited[startAlphabet] = true;

            dfsWithBacktracking(0, 0, 1);

            sb.append('#').append(testCase).append(' ')
                .append(maxSpecialityCount).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfsWithBacktracking(int r, int c, int count) {
        if (count > maxSpecialityCount) {
            maxSpecialityCount = count;
        }

        if (maxSpecialityCount == A_TO_Z) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                int nextAlphabet = map[nextR][nextC] - 'A';

                if (!visited[nextAlphabet]) {
                    visited[nextAlphabet] = true;
                    dfsWithBacktracking(nextR, nextC, count + 1);
                    visited[nextAlphabet] = false;
                }
            }
        }
    }

}
