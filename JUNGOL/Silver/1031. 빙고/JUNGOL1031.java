import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1031 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int BOARD_SIZE = 5;
        final int BOARD_SIZE_SQUARED = BOARD_SIZE * BOARD_SIZE;
        final int WINNER_LINE_COUNT = 3;

        int[][] positions = new int[BOARD_SIZE_SQUARED + 1][2]; // [][0] row, [][1] column

        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < BOARD_SIZE; j++) {
                int number = Integer.parseInt(st.nextToken());

                positions[number][0] = i;
                positions[number][1] = j;
            }
        }

        int bingoLineCount = 0;
        int[] rowBingo = new int[BOARD_SIZE];
        int[] columnBingo = new int[BOARD_SIZE];
        int leftDownDiagonal = 0;
        int rightDownDiagonal = 0;

        st = new StringTokenizer(br.readLine());
        for (int step = 1; step <= BOARD_SIZE_SQUARED; step++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            int number = Integer.parseInt(st.nextToken());
            int row = positions[number][0];
            int column = positions[number][1];

            rowBingo[row]++;
            if (rowBingo[row] == BOARD_SIZE) {
                bingoLineCount++;
            }

            columnBingo[column]++;
            if (columnBingo[column] == BOARD_SIZE) {
                bingoLineCount++;
            }

            if (row == column) {
                rightDownDiagonal++;
                if (rightDownDiagonal == BOARD_SIZE) {
                    bingoLineCount++;
                }
            }

            if (row + column == BOARD_SIZE - 1) {
                leftDownDiagonal++;
                if (leftDownDiagonal == BOARD_SIZE) {
                    bingoLineCount++;
                }
            }

            if (bingoLineCount >= WINNER_LINE_COUNT) {
                System.out.println(step);

                return;
            }
        }
    }

}
