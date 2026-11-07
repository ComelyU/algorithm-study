import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNGOL2930 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Team[] teams = new Team[N];
        for (int i = 0; i < N; i++) {
            teams[i] = new Team(i + 1);
        }

        int totalGames = N * (N - 1) / 2;
        for (int i = 0; i < totalGames; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int teamA = Integer.parseInt(st.nextToken()) - 1;
            int teamB = Integer.parseInt(st.nextToken()) - 1;
            int scoreA = Integer.parseInt(st.nextToken());
            int scoreB = Integer.parseInt(st.nextToken());

            if (scoreA > scoreB) {
                teams[teamA].score += 3;
            } else if (scoreA < scoreB) {
                teams[teamB].score += 3;
            } else {
                teams[teamA].score += 1;
                teams[teamB].score += 1;
            }
        }

        Arrays.sort(teams, Comparator.comparingInt(Team::getScore).reversed());

        teams[0].rank = 1;
        for (int i = 1; i < N; i++) {
            if (teams[i].score == teams[i - 1].score) {
                teams[i].rank = teams[i - 1].rank;
            } else {
                teams[i].rank = i + 1;
            }
        }

        int[] resultRanks = new int[N + 1];
        for (Team team : teams) {
            resultRanks[team.id] = team.rank;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(resultRanks[i]).append('\n');
        }

        System.out.print(sb);
    }

    static class Team {
        int id;
        int score;
        int rank;

        public Team(int id) {
            this.id = id;
            this.score = 0;
            this.rank = 0;
        }

        public int getScore() {
            return this.score;
        }
    }

}
