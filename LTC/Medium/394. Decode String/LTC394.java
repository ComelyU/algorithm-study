import java.util.*;

public class LTC394 {

    public String decodeString(String s) {
        Deque<Integer> repeatCountStack = new ArrayDeque<>();
        Deque<StringBuilder> prefixStringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();

        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                repeatCountStack.push(k);
                k = 0;

                prefixStringStack.push(currentString);
                currentString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder prefix = prefixStringStack.pop();
                int repeatCount = repeatCountStack.pop();

//                prefix.append(currentString.toString().repeat(repeatCount));
                for (int i = 0; i < repeatCount; i++) {
                    prefix.append(currentString);
                }

                currentString = prefix;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

}
