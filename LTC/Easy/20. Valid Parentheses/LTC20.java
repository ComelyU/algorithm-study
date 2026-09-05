import java.util.*;

public class LTC20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()
                    || (c == ')' && stack.peek() != '(')
                    || (c == ']' && stack.peek() != '[')
                    || (c == '}' && stack.peek() != '{')) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
