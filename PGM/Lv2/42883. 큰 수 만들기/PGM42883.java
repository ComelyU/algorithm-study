import java.util.*;

public class PGM42883 {
    public String solution(String number, int k) {
        char[] numberArray = number.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < numberArray.length; i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < numberArray[i]) {
                k--;
                stack.pop();
            }

            stack.push(numberArray[i]);
        }

        while(k-- > 0) {
            stack.pop();
        }

        StringBuilder result = new StringBuilder();

//        while(!stack.isEmpty()) {
//            result.append(stack.pop());
//        }

        for(char c : stack) {
            result.append(c);
        }

        return result.reverse().toString();
    }

}
