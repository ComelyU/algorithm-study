import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//// Topological Sort
//public class JUNGOL1021 {
//
//    private static int N;
//    private static int M;
//
//    private static ArrayList<ArrayList<Node>> recipes;
//    private static int[] indegrees;
//    private static int[][] totalCounts;
//    private static boolean[] isComposite;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
//
//        recipes = new ArrayList<>();
//        for (int i = 0; i <= N; i++) {
//            recipes.add(new ArrayList<>());
//        }
//
//        indegrees = new int[N + 1];
//        totalCounts = new int[N + 1][N + 1];
//        isComposite = new boolean[N + 1];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int X = Integer.parseInt(st.nextToken());
//            int Y = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//
//            recipes.get(Y).add(new Node(X, K));
//            indegrees[X]++;
//            isComposite[X] = true;
//        }
//
//        topologicalSort();
//
//        for (int i = 1; i <= N; i++) {
//            if (!isComposite[i] && totalCounts[N][i] > 0) {
//                sb.append(i).append(' ').append(totalCounts[N][i]).append('\n');
//            }
//        }
//
//        System.out.print(sb);
//    }
//
//    // 위상 정렬(Topological Sort)을 이용한 상향식 부품 개수 누적
//    private static void topologicalSort() {
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        for (int i = 1; i <= N; i++) {
//            if (indegrees[i] == 0) {
//                queue.offer(i);
//                totalCounts[i][i] = 1;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//
//            for (Node next : recipes.get(current)) {
//                for (int i = 1; i <= N; i++) {
//                    totalCounts[next.upper][i] += totalCounts[current][i] * next.count;
//                }
//
//                indegrees[next.upper]--;
//
//                if (indegrees[next.upper] == 0) {
//                    queue.offer(next.upper);
//                }
//            }
//        }
//    }
//
//    private static class Node {
//        int upper; // 상위 조립품
//        int count; // 필요 수량
//
//        Node(int upper, int count) {
//            this.upper = upper;
//            this.count = count;
//        }
//    }
//
//}

// DFS + Memoization
public class JUNGOL1021 {

    private static int N;
    private static int M;

    private static int[][] recipes;
    private static int[][] memo;
    private static boolean[] isComposite;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // primitive part -> composite part -> product
        // product도 composite part라 볼 수 있음

        recipes = new int[N + 1][N + 1];
        memo = new int[N + 1][N + 1];
        isComposite = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            recipes[X][Y] = K;
            isComposite[X] = true;
        }

        calculateCounts(N);

        for (int i = 1; i < N; i++) {
            if (!isComposite[i] && memo[N][i] > 0) {
                sb.append(i).append(' ').append(memo[N][i]).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static void calculateCounts(int now) {
        if (visited[now]) {
            return;
        }

        if (!isComposite[now]) {
            memo[now][now] = 1;
            visited[now] = true;
            return;
        }

        for (int i = 1; i < N; i++) {
            if (recipes[now][i] > 0) {
                calculateCounts(i);

                for (int j = 1; j < N; j++) {
                    memo[now][j] += memo[i][j] * recipes[now][i];
                }
            }
        }

        visited[now] = true;
    }

}
