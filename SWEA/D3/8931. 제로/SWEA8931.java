import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA8931 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int K = Integer.parseInt(br.readLine());

            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num == 0) { // 정수가 0일 경우에 지울 수 있는 수가 있음을 조건에서 보장
//                    stack.pop();
                    stack.pollLast();
                } else {
//                    stack.push(num);
                    stack.offerLast(num);
                }
            }

            int sum = 0;
            for (int num : stack) {
                sum += num;
            }

            sb.append('#').append(tc).append(' ').append(sum).append('\n');
        }

        System.out.println(sb);
    }

}
