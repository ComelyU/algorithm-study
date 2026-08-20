import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA5185 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append('#').append(testCase).append(' ');

            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            String hexadecimalNum = st.nextToken();

            for (int i = 0; i < N; i++) {
                int decimalNum = Integer.parseInt(String.valueOf(hexadecimalNum.charAt(i)), 16);

                String binaryNum = String.format("%4s", Integer.toBinaryString(decimalNum)).replace(' ', '0');

                sb.append(binaryNum);
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}
