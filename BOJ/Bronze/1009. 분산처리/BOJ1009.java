import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1009 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int repeatCount = 0;
            int computerNum = 1;

            int lastDigit = a % 10;

            if (lastDigit == 0 || lastDigit == 1 || lastDigit == 5 || lastDigit == 6) { // 거듭제곱 일의 자리 반복 주기 1
                computerNum = lastDigit;
            } else if (lastDigit == 4 || lastDigit == 9) { // 거듭제곱 일의 자리 반복 주기 2
                repeatCount = b % 2;
                if (repeatCount == 0) {
                    repeatCount = 2;
                }
            } else { // 거듭제곱 일의 자리 반복 주기 4
                repeatCount = b % 4;
                if (repeatCount == 0) {
                    repeatCount = 4;
                }
            }

            for (int i = 0; i < repeatCount; i++) {
                computerNum = (computerNum * a) % 10;
            }

            sb.append(computerNum == 0 ? 10 : computerNum).append('\n');
        }

        System.out.print(sb);
    }

}
