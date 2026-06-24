import java.util.*;

public class PGM12973 {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
