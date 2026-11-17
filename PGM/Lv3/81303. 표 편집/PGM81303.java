import java.util.*;

public class PGM81303 {

    private static final int NONE = -1;

    private static final char CMD_UP = 'U';
    private static final char CMD_DOWN = 'D';
    private static final char CMD_DELETE = 'C';
    private static final char CMD_RESTORE = 'Z';

    private static final char STATUS_ACTIVE = 'O';
    private static final char STATUS_DELETED = 'X';

    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] isDeleted = new boolean[n];

        initializeLinks(n, prev, next);

        Deque<Integer> deletedHistory = new ArrayDeque<>();
        int cursor = k;

        for (String command : cmd) {
            char action = command.charAt(0);

            switch (action) {
                case CMD_UP:
                    cursor = moveCursor(cursor, Integer.parseInt(command.substring(2)), prev);
                    break;
                case CMD_DOWN:
                    cursor = moveCursor(cursor, Integer.parseInt(command.substring(2)), next);
                    break;
                case CMD_DELETE:
                    cursor = deleteRow(cursor, prev, next, isDeleted, deletedHistory);
                    break;
                case CMD_RESTORE:
                    restoreRow(prev, next, isDeleted, deletedHistory);
                    break;
                default:
                    // 문제 조건에서 여기는 도달할 수 없음.
                    throw new IllegalArgumentException("Unsupported command: " + command);
            }
        }

        return buildResultStatus(n, isDeleted);
    }

    private void initializeLinks(int n, int[] prev, int[] next) {
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i == n - 1) ? NONE : i + 1;
        }
    }

    private int moveCursor(int current, int step, int[] links) {
        int target = current;

        for (int i = 0; i < step; i++) {
            target = links[target];
        }

        return target;
    }

    private int deleteRow(int current, int[] prev, int[] next, boolean[] isDeleted, Deque<Integer> deletedHistory) {
        deletedHistory.addLast(current);
        isDeleted[current] = true;

        int upRow = prev[current];
        int downRow = next[current];

        if (upRow != NONE) {
            next[upRow] = downRow;
        }

        if (downRow != NONE) {
            prev[downRow] = upRow;
        }

        return (downRow == NONE) ? upRow : downRow;
    }

    private void restoreRow(int[] prev, int[] next, boolean[] isDeleted, Deque<Integer> deletedHistory) {
        int restored = deletedHistory.removeLast(); // 비어있지 않음을 문제에서 보장
        isDeleted[restored] = false;

        int upRow = prev[restored];
        int downRow = next[restored];

        if (upRow != NONE) {
            next[upRow] = restored;
        }

        if (downRow != NONE) {
            prev[downRow] = restored;
        }
    }

    private String buildResultStatus(int n, boolean[] isDeleted) {
        StringBuilder statusBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            statusBuilder.append(isDeleted[i] ? STATUS_DELETED : STATUS_ACTIVE);
        }

        return statusBuilder.toString();
    }

}
