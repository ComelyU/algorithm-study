import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int distance = 0;
            int speed = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    distance += speed;
                } else if (command == 1) {
                    speed += Integer.parseInt(st.nextToken());
                    distance += speed;
                } else {
                    speed -= Integer.parseInt(st.nextToken());
                    if (speed < 0) {
                        speed = 0;
                    }
                    distance += speed;
                }
            }

            sb.append('#').append(testCase).append(' ').append(distance).append('\n');
        }

        System.out.println(sb);
    }

}
