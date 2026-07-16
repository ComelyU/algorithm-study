import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1220 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int testCase = 1; testCase <= 10; testCase++) {
            int length = Integer.parseInt(br.readLine());
            int[][] table = new int[length][length];

            for(int i = 0; i < length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < length; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int deadlockCount = 0;
            for(int col = 0; col < length; col++) {
                // 푸른 자성체 Flag.
                // true: 푸른 자성체, false: 붉은 자성체.
                // 푸른 자성체는 S극 성질이라 N극에, 붉은 자성체는 N극 성질이라 S극에 이끌림.
                boolean isBlue = false;

                for(int row = length - 1; row >= 0; row--) {
                    if(table[row][col] == 2) {
                        isBlue = true;
                    } else if(table[row][col] == 1 && isBlue) {
                        deadlockCount++;
                        isBlue = false; // 교착 상태 확인 후 초기값으로.
                    }
                }
            }

            sb.append('#').append(testCase).append(' ').append(deadlockCount).append('\n');
        }

        System.out.println(sb.toString());
    }

}
