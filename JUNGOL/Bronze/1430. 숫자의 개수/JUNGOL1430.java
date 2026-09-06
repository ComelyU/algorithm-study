import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1430 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] num = new int[10];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int product = A * B * C;
        while (product > 0) {
            num[product % 10]++;
            product /= 10;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(num[i]).append('\n');
        }

        System.out.println(sb.toString());
    }

}
