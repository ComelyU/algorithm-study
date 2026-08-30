import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA1234 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append('#').append(testCase).append(' ');

            st = new StringTokenizer(br.readLine(), " ");

            int length = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for (int i = 0; i < length; i++) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == str.charAt(i)) { // isEmpty()는 java 8에서 사용 불가.
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(str.charAt(i));
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        for (int testCase = 1; testCase <= 10; testCase++) {
//            sb.append('#').append(testCase).append(' ');
//
//            st = new StringTokenizer(br.readLine(), " ");
//
//            int length = Integer.parseInt(st.nextToken());
//            String str = st.nextToken();
//
//            Deque<Character> stack = new ArrayDeque<>();
//
//            for (int i = 0; i < length; i++) {
//                if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
//                    stack.pop();
//                } else {
//                    stack.push(str.charAt(i));
//                }
//            }
//
//            StringBuilder password = new StringBuilder();
//            for (char c : stack) {
//                password.append(c);
//            }
//            password.reverse();
//
//            sb.append(password.toString()).append('\n');
//        }
//
//        System.out.println(sb.toString());
//    }

}
