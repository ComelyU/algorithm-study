import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {

    private static int N;
    private static ArrayList<ArrayList<Integer>> checkTrust = new ArrayList<>(); // 인접리스트. O[V+E]
    private static int[] countArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        checkTrust = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) {
            checkTrust.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            // A B 형태로 주어지는데, 이는 A가 B를 신뢰한다는 의미. 이 경우 B를 해킹하면 A도 해킹 가능.
            // 역방향으로 저장하면 A가 해킹되면 B도 해킹된다는 뜻. 즉, 해킹이 퍼져나가는 방향을 의미.
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            checkTrust.get(A).add(B);
        }

        countArr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, countArr[i]);
        }

        for(int i = 1; i <= N; i++) {
            if(countArr[i] == max) {
                sb.append(i).append(" ");
            }
        }
        sb.append("\n");

        System.out.println(sb.toString());
    }

    private static void bfs(int comNum) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(comNum);
        visited[comNum] = true;

        while(!queue.isEmpty()) {
            int nowCom = queue.poll();

            for(int nextCom : checkTrust.get(nowCom)) {
                if(!visited[nextCom]) {
                    visited[nextCom] = true;
                    countArr[nextCom]++; // 현재 컴퓨터를 통해 해킹될 수 있는 컴퓨터의 카운트 증가
                    queue.offer(nextCom);
                }
            }
        }
    }
}
