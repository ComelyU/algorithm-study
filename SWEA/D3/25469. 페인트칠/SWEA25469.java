import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA25469 {

    private static final int UNVISITED = 0;
    private static final int EXCLUDED = -1;
    private static final int SELECTED = 1;

    // 그리디 + 큐
    // 그리디(Greedy)와 위수 관계(차수 기반 제거)로 접근하여 큐(Queue)를 이용해 풀이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] grid = new char[H][W];

            for (int i = 0; i < H; i++) {
                grid[i] = br.readLine().trim().toCharArray();
            }

            sb.append(solveGreedy(H, W, grid)).append('\n');
        }

        System.out.print(sb);
    }

    private static int solveGreedy(int H, int W, char[][] grid) {
        // 0 ~ H-1: 행 노드, H ~ H+W-1: 열 노드
        boolean[] alive = new boolean[H + W];
        Arrays.fill(alive, true);

        // 정점의 상태: 0 = 미결정, 1 = 선택 확정(연산 포함), -1 = 선택 안함(제외)
        int[] state = new int[H + W];

        Queue<Integer> queue = new ArrayDeque<>();

        // 초기 상태 설정: 흰색 칸을 베이스로 절대 고를 수 없는 행과 열 찾기
        initExcludeNodes(H, W, grid, alive, state, queue);

        // 위상 정렬/큐를 이용해 연쇄 확정 연산 수행
        int operationCount = processCascadeEffect(H, W, grid, alive, state, queue);

        // 독립된 나머지(잔여 행/열) 처리 + 최종 카운트 합산
        operationCount += calculateRemainingMinimum(H, W, alive);

        return operationCount;
    }

    private static void initExcludeNodes(int H, int W, char[][] grid, boolean[] alive, int[] state, Queue<Integer> queue) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == '.') {
                    excludeNode(i, alive, state, queue); // 행 제외
                    excludeNode(H + j, alive, state, queue); // 열 제외
                }
            }
        }
    }

    private static void excludeNode(int nodeIndex, boolean[] alive, int[] state, Queue<Integer> queue) {
        if (alive[nodeIndex]) {
            alive[nodeIndex] = false;
            state[nodeIndex] = EXCLUDED;
            queue.offer(nodeIndex);
        }
    }

    private static int processCascadeEffect(int H, int W, char[][] grid, boolean[] alive, int[] state, Queue<Integer> queue) {
        int currentOperationCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (state[current] == EXCLUDED) {
                currentOperationCount += handleExcludeNodeNeighbors(current, H, W, grid, alive, state, queue);
            } else if (state[current] == SELECTED) {
                handleSelectedNodeNeighbors(current, H, W, grid, alive, state, queue);
            }
        }

        return currentOperationCount;
    }

    private static int handleExcludeNodeNeighbors(int current, int H, int W, char[][] grid, boolean[] alive, int[] state, Queue<Integer> queue) {
        // 제외된 노드와 교차하는 # 칸의 반대편 노드들을 필수 선택으로 만들기
        int newSelectedCount = 0;

        if (current < H) { // 현 노드가 행인 경우
            int row = current;

            for (int column = 0; column < W; column++) {
                if (grid[row][column] == '#' && alive[H + column]) {
                    alive[H + column] = false;
                    state[H + column] = SELECTED;
                    queue.offer(H + column);
                    newSelectedCount++;
                }
            }
        } else { // 현 노드가 열인 경우
            int column = current - H;

            for (int row = 0; row < H; row++) {
                if (grid[row][column] == '#' && alive[row]) {
                    alive[row] = false;
                    state[row] = SELECTED;
                    queue.offer(row);
                    newSelectedCount++;
                }
            }
        }

        return newSelectedCount;
    }

    private static void handleSelectedNodeNeighbors(int current, int H, int W, char[][] grid, boolean[] alive, int[] state, Queue<Integer> queue) {
        // 선택된 노드와 교차하는 # 칸의 반대편 노드들을 제외로 만들기
        if (current < H) { // 현 노드가 행인 경우
            int row = current;

            for (int column = 0; column < W; column++) {
                if (grid[row][column] == '#' && alive[H + column]) {
                    alive[H + column] = false;
                    state[H + column] = EXCLUDED; // 이미 행이 지워져 반대편 열은 선택하지 않아도 됨
                    queue.offer(H + column);
                }
            }
        } else { // 현 노드가 열인 경우
            int column = current - H;

            for (int row = 0; row < H; row++) {
                if (grid[row][column] == '#' && alive[row]) {
                    alive[row] = false;
                    state[row] = EXCLUDED; // 이미 열이 지워져 반대편 행은 선택하지 않아도 됨.
                    queue.offer(row);
                }
            }
        }
    }

    private static int calculateRemainingMinimum(int H, int W, boolean[] alive) {
        int remainingRows = 0;
        int remainingColumns = 0;

        for (int i = 0; i < H; i++) {
            if (alive[i]) {
                remainingRows++;
            }
        }

        for (int j = 0; j < W; j++) {
            if (alive[H + j]) {
                remainingColumns++;
            }
        }

        return Math.min(remainingRows, remainingColumns);
    }

}
