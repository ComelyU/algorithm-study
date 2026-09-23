import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA23791 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] aTeamPicks = new int[N];
            int[] bTeamPicks = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                aTeamPicks[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                bTeamPicks[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            char[] picked = new char[N + 1];

            int aTeamIndex = 0;
            int bTeamIndex = 0;
            boolean isATeamTurn = true;

            for (int i = 0; i < N; i++) {
                if (isATeamTurn) {
                    while (aTeamIndex < N && visited[aTeamPicks[aTeamIndex]]) {
                        aTeamIndex++;
                    }

                    if (aTeamIndex < N) {
                        int player = aTeamPicks[aTeamIndex];
                        picked[player] = 'A';
                        visited[player] = true;
                    }
                } else {
                    while (bTeamIndex < N && visited[bTeamPicks[bTeamIndex]]) {
                        bTeamIndex++;
                    }

                    if (bTeamIndex < N) {
                        int player = bTeamPicks[bTeamIndex];
                        picked[player] = 'B';
                        visited[player] = true;
                    }
                }

                isATeamTurn = !isATeamTurn;
            }

            for (int i = 1; i <= N; i++) {
                sb.append(picked[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
