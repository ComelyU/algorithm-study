import java.util.*;

public class PGM77886 {

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            Deque<Character> deque = new ArrayDeque<>();

            String str = s[i];
            int count110 = 0;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '0' && deque.size() >= 2) {
                    char top = deque.pollLast();
                    char nextTop = deque.pollLast();

                    if (top == '1' && nextTop == '1') {
                        count110++;
                        continue;
                    }

                    deque.addLast(nextTop);
                    deque.addLast(top);
                }

                deque.addLast(ch);
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }

//            StringBuilder repaeat110Str = new StringBuilder();
//            while (count110-- > 0) {
//                repaeat110Str.append("110");
//            }
            String repeat110Str = "110".repeat(count110);

            int insertIdx = sb.lastIndexOf("0");

            if (insertIdx != -1) {
                sb.insert(insertIdx + 1, repeat110Str);
            } else {
                sb.insert(0, repeat110Str);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

}
