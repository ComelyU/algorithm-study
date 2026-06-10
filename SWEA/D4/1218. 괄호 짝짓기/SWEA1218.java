import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SWEA1218 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1; testCase <= 10; testCase++) {
            int inputLength = Integer.parseInt(br.readLine());
//            String input = br.readLine();
            char[] input = br.readLine().toCharArray();
            int isValid = 1;

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < inputLength; i++) {
//                char bracket = input.charAt(i);
                char bracket = input[i];

                if(bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
//                    stack.add(bracket);
                    stack.push(bracket);
                } else if(bracket == ')' || bracket == ']' || bracket == '}' || bracket == '>') {
                    if(stack.isEmpty()) {
                        isValid = 0;
                        break;
                    }

//                    char top = stack.removeLast();
                    char top = stack.pop();

                    if(bracket == ')' && top != '(') {
                        isValid = 0;
                    } else if(bracket == ']' && top != '[') {
                        isValid = 0;
                    } else if(bracket == '}' && top != '{') {
                        isValid = 0;
                    } else if(bracket == '>' && top != '<') {
                        isValid = 0;
                    }

                    if(isValid == 0) {
                        break;
                    }
                }
            }

            if(!stack.isEmpty()) {
                isValid = 0;
            }

            sb.append('#').append(testCase).append(' ').append(isValid).append('\n');
        }

        System.out.println(sb.toString());
    }

}
