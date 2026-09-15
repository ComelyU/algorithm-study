import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA24696 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            long unitCubeCount = (long) A * B * C; // 직육면체의 단위 정육면체 개수
            long cutCubeCount = unitCubeCount - 1; // 직육면체를 자르는 경우의 수

            sb.append(cutCubeCount % 2 != 0 ? 1 : 2).append('\n');
        }

        System.out.println(sb.toString());
    }

}
