import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1109 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        // a <= b <= c
        int aLimit = n / 3;
        int bLimit = n / 2;
        for (int a = 1; a <= aLimit; a++) {
            for (int b = a; b <= bLimit; b++) {
                int c = n - a - b;

                if (c < b) {
                    break;
                }

                // 삼각형 성립 조건: 가장 긴 변(c)이 나머지 두 변의 합(a + b)보다 작아야 함
                if (a + b > c) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
