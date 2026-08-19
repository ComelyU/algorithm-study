import java.util.*;

public class PGM64061 {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> basketStack = new ArrayDeque<>();

        int answer = 0;
        for (int move : moves) {
            int column = move - 1; // 1-based index to 0-based index

            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != 0) {
                    int doll = board[row][column];
                    board[row][column] = 0;

                    // ArrayDeque을 stack으로 사용하는 상황
                    // LIFO 형태로 사용하려면 push/pop/peek의 방향을 통일해야 함
                    if (!basketStack.isEmpty() && basketStack.peek() == doll) {
                        basketStack.pop();

                        answer += 2;
                    } else {
                        basketStack.push(doll);
                    }

                    break; // 인형을 하나 뽑았으므로 해당 move 종료
                }
            }
        }

        return answer;
    }
}
