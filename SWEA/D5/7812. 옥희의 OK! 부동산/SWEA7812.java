import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA7812 {

//    // Prefix Sum + Binary Search (땅의 시가가 자연수 범위라 가능) - 결과 9 / 10
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine());
//        for(int testCase = 1; testCase <= T; testCase++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            // prefix sum
//            int[] prefixSum = new int[N + 1];
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int i = 1; i <= N; i++) {
//                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
//            }
//
//            // binary search
//            int count = 0;
//            for(int i = 1; i <= N; i++) { // 각 시작 지점(i - 1)에 대해 조건에 맞는 값이 있는지
//                int target = prefixSum[i - 1] + M;
//
//                // i번재부터 N번째 누적 합 중에서 target search
//                int index = Arrays.binarySearch(prefixSum, i, N + 1, target);
//
//                if(index >= 0) { // 반환값이 0 이상이면 값을 찾은 것
//                    count++;
//                }
//            }
//
//            sb.append('#').append(testCase).append(' ').append(count).append('\n');
//        }
//
//        System.out.println(sb.toString());
//    }

//    // Prefix Sum + HashMap
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine());
//        for(int testCase = 1; testCase <= T; testCase++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            // key: 누적 합, value: 등장 횟수
//            Map<Integer, Integer> prefixSumMap = new HashMap<>();
//            prefixSumMap.put(0, 1); // 아무것도 더하지 않은 초기 상태 존재
//
//            int prefixSum = 0;
//            int count = 0;
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int i = 0; i < N; i++) {
//                prefixSum += Integer.parseInt(st.nextToken());
//
//                count += prefixSumMap.getOrDefault(prefixSum - M, 0);
//
//                prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
//            }
//
//            sb.append('#').append(testCase).append(' ').append(count).append('\n');
//        }
//
//        System.out.println(sb.toString());
//    }

    // Two-Pointer + Sliding Window (땅의 시가가 자연수 범위라 가능)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] values = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }

            int left = 0;
            int right = 0;
            int sum = 0;
            int count = 0;
            while(left < N) {
                if(sum >= M || right == N) { // 합이 M 이상이거나 오른쪽 포인터가 끝에 도달한 경우 왼쪽 포인터 범위 줄이기
                    sum -= values[left++];
                } else { // 합이 M보다 작은 경우 오른쪽 포인터 범위 늘리기
                    sum += values[right++];
                }

                if(sum == M) {
                    count++;
                }
            }

            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }

        System.out.println(sb.toString());
    }
}
