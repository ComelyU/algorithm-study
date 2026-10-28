import java.util.*;

public class PGM67259 {

    // 상하좌우
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int size = board.length;

        // 3차원 최소 비용 배열. [x][y][진입 방향]
        int[][][] minCost = new int[size][size][4];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }

        return findMinCostPath(board, minCost, size);
    }

    // 우선순위 큐(PQ) 기반 다익스트라(Dijkstra) 알고리즘
    private int findMinCostPath(int[][] board, int[][][] minCost, int size) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        pq.offer(new Node(0, 0, -1, 0)); // 첫 진입은 방향 제한 없음. -1로 설정.

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 목적지 도착 시 즉시 최솟값 반환
            if (current.x == size - 1 && current.y == size - 1) {
                return current.cost;
            }

            // 가지치기: 이미 기록된 최소 비용보다 비싸면 스킵
            if (current.dir != -1 && current.cost > minCost[current.x][current.y][current.dir]) {
                continue;
            }

            // 인접 칸 탐색 (4 방향)
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size || board[nextX][nextY] == 1) {
                    continue;
                }

                // 직선/코너 비용 계산
                // 첫 출발이거나 진행 방향이 같으면 직선, 아니면 코너
                int nextCost = current.cost + (current.dir == -1 || current.dir == i ? 100 : 600);

                // 이동할 칸의 해당 방향 진입 비용이 기존보다 저렴하면 갱신 후 큐에 넣기
                if (nextCost < minCost[nextX][nextY][i]) {
                    minCost[nextX][nextY][i] = nextCost;
                    pq.offer(new Node(nextX, nextY, i, nextCost));
                }
            }
        }

        return 0; // 예외 케이스 처리 (목적지 도착 불가)
    }

    private static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

}
