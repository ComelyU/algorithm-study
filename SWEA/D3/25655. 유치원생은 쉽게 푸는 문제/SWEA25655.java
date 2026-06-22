import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA25655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int X = Integer.parseInt(br.readLine());

//            if(X == 0) {
//                sb.append("1\n");
//                continue;
//            }
            if(X == 1) {
                sb.append("0\n");
                continue;
            }

            if(X % 2 == 0) {
//                sb.append("8".repeat(X / 2)); // Java 11 이상
                int count = X / 2;
                while(count-- > 0) {
                    sb.append('8');
                }
            } else {
//                sb.append('4').append("8".repeat((X - 1) / 2)); // Java 11 이상
                sb.append('4');
                int count = (X - 1) / 2;
                while(count-- > 0) {
                    sb.append('8');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}
