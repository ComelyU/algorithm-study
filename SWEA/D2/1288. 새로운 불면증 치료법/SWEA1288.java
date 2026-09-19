import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1288 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[10];
            int count = 0;
            int totalDiffNum = 0;

            while (totalDiffNum < 10) {
                count++;
                int current = N * count;

                while (current > 0) {
                    int digit = current % 10;

                    if (!visited[digit]) {
                        visited[digit] = true;
                        totalDiffNum++;
                    }

                    current /= 10;
                }
            }

            sb.append('#').append(testCase).append(' ')
                .append(N * count).append('\n');
        }

        System.out.println(sb);
    }
}
