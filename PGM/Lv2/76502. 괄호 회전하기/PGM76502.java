import java.util.*;

public class PGM76502 {
    public int solution(String s) {
        int sLength = s.length();

        if (sLength % 2 != 0) {
            return 0;
        }

        String doubleS = s + s;
        int answer = 0;

        for (int i = 0; i < sLength; i++) {
            char first = doubleS.charAt(i);

            if (first == ')' || first == ']' || first == '}') {
                continue;
            }

            if (isValid(doubleS, i, sLength)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isValid(String str, int start, int sLength) {
        Deque<Character> stack = new ArrayDeque<>();
        int end = start + sLength;

        for (int i = start; i < end; i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
