import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1036 {

    // 1 ~ 9번까지의 방향 벡터 정의(인덱스 0번은 사용하지 않음)
    // _,남서, 남, 남동, 서, 끝, 동, 북서, 북, 북동 (쉽게 키보드의 텐키 떠올리기)
    private static final int[] dx = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    private static final int[] dy = {0, -1, -1, -1, 0, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String path = br.readLine().trim(); // trim()으로 눈에 띄지 않는 공백 처리

            // 원점 시작
            int currentX = 0;
            int currentY = 0;

            // 신발끈 공식(사선 공식)을 활용해 벡터의 외적 누적값 계산
            // (x_1, y_1), (x_2, y_2), ..., (x_n, y_n)으로 다각형의 꼭짓점 좌표가 주어진 경우
            // [신발끈 공식]: 1/2 * |∑(x_i * y_{i+1} - x_{i+1} * y_i)|
            long prefixSumOfCrossProducts = 0; // = cumulativeSumOfCrossProducts

            for (int i = 0; i < path.length(); i++) {
                int dir = path.charAt(i) - '0';

                if (dir == 5) {
                    break;
                }

                int nextX = currentX + dx[dir];
                int nextY = currentY + dy[dir];

                prefixSumOfCrossProducts += (long) currentX * nextY - (long) nextX * currentY;

                currentX = nextX;
                currentY = nextY;
            }

            prefixSumOfCrossProducts = Math.abs(prefixSumOfCrossProducts);

            if (prefixSumOfCrossProducts % 2 == 0) {
                sb.append(prefixSumOfCrossProducts / 2).append('\n');
            } else {
                sb.append(prefixSumOfCrossProducts / 2).append(".5\n");
            }
        }

        System.out.println(sb);
    }

}
