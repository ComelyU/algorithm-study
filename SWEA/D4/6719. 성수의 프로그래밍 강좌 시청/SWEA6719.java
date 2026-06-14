import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA6719 {

//    // 우선순위 큐
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine());
//        for(int testCase = 1; testCase <= T; testCase++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int N = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//
//            // 최소 힙(Min-Heap)
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int i = 0; i < N; i++) {
//                int lectureLevel = Integer.parseInt(st.nextToken());
//
//                if(pq.size() < K) {
//                    pq.offer(lectureLevel);
//                } else if(!pq.isEmpty() && lectureLevel > pq.peek()) {
//                    pq.poll();
//                    pq.offer(lectureLevel);
//                }
//            }
//
//            double skillLevel = 0;
//            while(!pq.isEmpty()) {
//                skillLevel = (skillLevel + pq.poll()) / 2.0;
//            }
//
//            sb.append('#').append(testCase).append(' ').append(String.format("%.6f", skillLevel)).append('\n');
//        }
//
//        System.out.println(sb.toString());
//    }

    // 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] lectureLevelArr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                lectureLevelArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(lectureLevelArr);

            double skillLevel = 0;
            for(int i = N - K; i < N; i++) {
                skillLevel = (skillLevel + lectureLevelArr[i]) / 2.0;
            }

            sb.append('#').append(testCase).append(' ').append(String.format("%.6f", skillLevel)).append('\n');
        }

        System.out.println(sb.toString());
    }
}
