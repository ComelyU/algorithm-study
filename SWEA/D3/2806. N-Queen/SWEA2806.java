import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2806 {

    private static int promisingCount;
    private static int[] columns;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            promisingCount = 0;
            columns = new int[N];

            recursionWithBacktracking(0, N);

            sb.append('#').append(testCase).append(' ').append(promisingCount).append('\n');
        }

        System.out.println(sb);
    }

    private static void recursionWithBacktracking(int row, int n) {
        if(row == n) {
            promisingCount++;
            return;
        }

        for(int column = 0; column < n; column++) {
            if(isPromising(row, column)) {
                columns[row] = column;
                recursionWithBacktracking(row + 1, n);
                // columsn[row] = column으로 했기에 columns[row] = 0 필요 없음.
                // 만약, 위치해있음을 1로 표현하는 방식(columns[row] = 1)이면 사용해야 함.
                // 이 경우 isPromising 내 조건도 수정 필요
            }
        }
    }

    private static boolean isPromising(int row, int column) {
        for(int i = 0; i < row; i++) {
            // 같은 열에 있거나 대각선상에 있는 경우
            if(columns[i] == column || Math.abs(row - i) == Math.abs(column - columns[i])) {
                return false;
            }
        }

        return true;
    }

}
