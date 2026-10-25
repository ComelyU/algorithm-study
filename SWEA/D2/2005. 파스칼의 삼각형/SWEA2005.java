import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] triangle = new int[N][N]; // [N][]인 비정형 대신 [N][N] 정형 배열로

            sb.append('#').append(tc).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        triangle[i][j] = 1;
                    } else {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    }

                    sb.append(triangle[i][j]);
                    if (j < i) {
                        sb.append(' ');
                    }
                }

                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

}
