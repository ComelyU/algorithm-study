import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA10804 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append('#').append(testCase).append(' ');

//            char[] input = br.readLine().toCharArray();
            String input = br.readLine();

//            for(int i = input.length - 1; i >= 0; i--) {
            for(int i = input.length() - 1; i >= 0; i--) {
//                char c = input[i];
                char c = input.charAt(i);

                if(c == 'b') {
                    sb.append('d');
                } else if(c == 'd') {
                    sb.append('b');
                } else if(c == 'p') {
                    sb.append('q');
                } else {
                    sb.append('p');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}
