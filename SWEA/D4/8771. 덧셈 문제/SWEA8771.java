import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA8771 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");

            long N = Integer.parseInt(st.nextToken());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());

            long count = 0;
            if(A > B) { // 최솟값이 최댓값보다 큰 경우 불가
                count = 0;
            } else if(N == 1 && A != B) { // 1개의 정수를 갖는데, 최솟값이 최댓값과 다르면 모순
                count = 0;
            } else {
                // 최솟값과 최댓값은 각각 한 번은 무조건 포함
                // 최대 합 = A + B + (N - 2) * B
                // 최소 합 = A + B + (N - 2) * A
                // 가능한 경우의 수는 (최대 합 - 최소 합 + 1) (x이상 y이하 개수 세기)
                count = (N - 2) * (B - A) + 1;
            }

            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }

        System.out.println(sb.toString());
    }

}
