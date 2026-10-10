import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1116 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = Integer.MIN_VALUE; // 숫자의 범위가 자연수, 0 이하면 됨.
        int maxRow = 0;
        int maxColumn = 0;

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > maxValue) { // >= 도 가능.(최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력)
                    maxValue = value;
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append('\n').append(maxRow + 1).append(' ').append(maxColumn + 1).append('\n');

        System.out.println(sb);
    }

}
