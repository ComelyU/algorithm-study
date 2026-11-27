import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1215 {

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append('#').append(tc).append(' ');

            int palindromeLength = Integer.parseInt(br.readLine().trim());
            char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

            for (int i = 0; i < BOARD_SIZE; i++) {
                board[i] = br.readLine().trim().toCharArray();
            }

            int palindromeCount = getPalindromeCount(palindromeLength, board);

            sb.append(palindromeCount).append('\n');
        }

        System.out.println(sb);
    }

    private static int getPalindromeCount(int palindromeLength, char[][] board) {
        if (palindromeLength <= 0 || palindromeLength > BOARD_SIZE) {
            return 0;
        }
        if (palindromeLength == 1) {
            return BOARD_SIZE * BOARD_SIZE;
        }

        int palindromeCount = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j <= BOARD_SIZE - palindromeLength; j++) {
                boolean isRowPalindrome = true;
                boolean isColPalindrome = true;

                for (int k = 0; k < palindromeLength / 2; k++) {
                    int leftIndex = j + k;
                    int rightIndex = j + palindromeLength - 1 - k;

                    if (board[i][leftIndex] != board[i][rightIndex]) {
                        isRowPalindrome = false;
                    }
                    if (board[leftIndex][i] != board[rightIndex][i]) {
                        isColPalindrome = false;
                    }

                    if (!isRowPalindrome && !isColPalindrome) {
                        break;
                    }
                }

                if (isRowPalindrome) {
                    palindromeCount++;
                }
                if (isColPalindrome) {
                    palindromeCount++;
                }
            }
        }

        return palindromeCount;
    }

}
