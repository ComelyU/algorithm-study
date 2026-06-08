import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
//        int[][] farm;
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
//            farm = new int[N][N];

//            for(int i = 0; i < N; i++) {
//                char[] line = br.readLine().toCharArray();
//                for(int j = 0; j < N; j++) {
//                    farm[i][j] = line[j] - '0';
//                }
//            }
//
//            int midSize = N / 2;
//            int cropValue = 0;
//            for(int i = 0; i < N; i++) {
//                int unharvestedZone = Math.abs(midSize - i); // 행별 양쪽 끝에서 시작하여 수확을 하지 않는 농장 크기
//
//                for(int j = unharvestedZone; j < N - unharvestedZone; j++) {
//                    cropValue += farm[i][j];
//                }
//            }

            int midSize = N / 2;
            int cropValue = 0;

            for(int i = 0; i < N; i++) {
                int unharvestedZone = Math.abs(midSize - i);
                char[] line = br.readLine().toCharArray();

                for(int j = unharvestedZone; j < N - unharvestedZone; j++) {
                    cropValue += line[j] - '0';
                }
            }

            sb.append('#').append(testCase).append(' ').append(cropValue).append('\n');
        }

        System.out.println(sb.toString());
    }

}