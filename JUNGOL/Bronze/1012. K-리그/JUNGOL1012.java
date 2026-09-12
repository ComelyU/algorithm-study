import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1012 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 경기의 수 = N, 승패가 갈린 경기의 수 = W, 비긴 경기의 수 = D
        // N = W + D
        // 전체 승점 = S = 3W + 2D
        // W = N - D
        // S = 3 * (N - D) + 2D = 3N - D
        // D = 3N - S

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int S = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String team = st.nextToken();
            S += Integer.parseInt(st.nextToken());
        }

        System.out.println(3 * N - S);
    }

}
