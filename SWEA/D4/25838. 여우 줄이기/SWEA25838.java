import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA25838 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine().trim();

            Deque<Character> stack = new ArrayDeque<>(); // 배열과 포인터 이용해도 됨.

            for (int i = 0; i < N; i++) {
                char c = input.charAt(i);

                if (c == 'x' && stack.size() >= 2) {
                    if (stack.peek() == 'o') {
                        char top = stack.pop();

                        if (stack.peek() == 'f') {
                            stack.pop();
                        } else {
                            stack.push(top);
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            sb.append(stack.size()).append('\n');
        }

        System.out.println(sb);
    }

}