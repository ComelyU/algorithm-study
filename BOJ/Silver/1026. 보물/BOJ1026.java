import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1026 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // int[] 오름차순 후 교차 곱(A[i] * B[N-1-i])으로 박싱 오버헤드를 줄일 수 있으나, 코드 직관성을 위해 Integer[] 내림차순 정렬 선택
        Integer[] A = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, Comparator.reverseOrder());

        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        // 문제 조건상 B는 재배열 불가하나, 출력값이 최솟값 S뿐이므로 visited 배열이나 우선순위 큐 대신 정렬로 대체
        Arrays.sort(B);

        int minS = 0;
        for(int i = 0; i < N; i++) {
            minS += A[i] * B[i];
        }

        System.out.println(minS);
    }

}
