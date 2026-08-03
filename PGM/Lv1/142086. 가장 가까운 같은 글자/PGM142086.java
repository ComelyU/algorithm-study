import java.util.*;

public class PGM142086 {

    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int sLen = s.length();
        int[] answer = new int[sLen];

        Arrays.fill(answer, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                answer[i] = i - map.get(c);
            }

            map.put(c, i);
        }

        return answer;
    }

}
