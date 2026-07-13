import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1285 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int minDiff = Integer.MAX_VALUE;
            int count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while (N-- > 0) {
                int diff = Math.abs(Integer.parseInt(st.nextToken())); // 0과 돌이 떨어진 위치 사이 거리 절댓값

                if (diff < minDiff) {
                    minDiff = diff;
                    count = 1;
                } else if (diff == minDiff) {
                    count++;
                }
            }

            sb.append('#').append(testCase).append(' ')
                .append(minDiff).append(' ').append(count).append('\n');
        }

        System.out.println(sb.toString());
    }

}
