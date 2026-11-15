import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1042 {

    // 내장 메서드 사용 (36진법까지 가능)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String num1Str = br.readLine();
        String num2Str = br.readLine();

        int num1 = Integer.parseInt(num1Str, N);
        int num2 = Integer.parseInt(num2Str, N);

        int sum = num1 + num2;

        String sumInBaseN = Integer.toString(sum, N).toUpperCase();

        System.out.println(sum);
        System.out.println(sumInBaseN);
    }

}
