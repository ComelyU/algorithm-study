import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9015 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 단조증가/감소 체크
            int subArrCount = 1;
            int monotonicallyDir = 0; // 0: 미정, 1: 증가, 2: 감소
            for(int i = 1; i < n; i++) {
                if(arr[i] > arr[i - 1]) { // 증가하는 경우
                    if(monotonicallyDir == -1) { // 기존 배열이 단조감소
                        subArrCount++; // 부분 배열 분할 개수 증가
                        monotonicallyDir = 0; // 방향은 다음을 보고 결정
                    } else {
                        monotonicallyDir = 1; // 증가 방향 유지
                    }
                } else if(arr[i] < arr[i - 1]) { // 감소하는 경우
                    if(monotonicallyDir == 1) { // 기존 배열이 단조증가
                        subArrCount++; // 부분 배열 분할 개수 증가
                        monotonicallyDir = 0; // 방향은 다음을 보고 결정
                    } else {
                        monotonicallyDir = -1; // 감소 방향 유지
                    }
                }

                // 증가/감소하지 않고 같은 경우는 방향 유지하고 통과
            }

            sb.append('#').append(testCase).append(' ').append(subArrCount).append('\n');
        }

        System.out.println(sb.toString());
    }

}
