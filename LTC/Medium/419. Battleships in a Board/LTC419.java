public class LTC419 {

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int battleshipCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }

                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }

                battleshipCount++;
            }
        }

        return battleshipCount;
    }

}
