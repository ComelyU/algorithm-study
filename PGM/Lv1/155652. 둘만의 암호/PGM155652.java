import java.util.*;
import java.util.stream.Collectors;

public class PGM155652 {

    public String solution(String s, String skip, int index) {
        // skip에 포함되지 않는 알파벳 리스트
        List<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.indexOf(c) == -1) {
                alphabet.add(c);
            }
        }

        StringBuilder answer = new StringBuilder();
//        int sLength = s.length();
        int alphabetSize = alphabet.size();

//        for (int i = 0; i < sLength; i++) {
//            char c = s.charAt(i);
//            int currentIndex = alphabet.indexOf(c);
//            int nextIndex = (currentIndex + index) % alphabetSize;
//
//            answer.append(alphabet.get(nextIndex));
//        }

        for (char c : s.toCharArray()) {
            int currentIndex = alphabet.indexOf(c);
            int nextIndex = (currentIndex + index) % alphabetSize;

            answer.append(alphabet.get(nextIndex));
        }

        return answer.toString();
    }

//    // Stream API 사용
//    public String solution(String s, String skip, int index) {
//        // skip에 포함되지 않는 알파벳 리스트
//        List<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars()
//            .mapToObj(c -> (char) c)
//            .filter(c -> skip.indexOf(c) == -1)
//            .toList();
//
//        return s.chars()
//            .mapToObj(c -> {
//                int currentIndex = alphabet.indexOf((char) c);
//                int nextIndex = (currentIndex + index) % alphabet.size();
//
//                return String.valueOf(alphabet.get(nextIndex));
//            })
//            .collect(Collectors.joining());
//    }

}
