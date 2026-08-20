import java.io.BufferedReader;

public class SWEA22039 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // f(n) = f(n - 1) + f(n - 2)
            // 이항하면 f(n) - f(n - 1) - f(n - 2) = 0
            // 즉, 뒤의 가장 큰 항을 집합 A에, 앞의 두 항을 집합 B에 넣으면 조건 만족.
            // N mod 3 == 0: 3개씩 그룹화 가능. BBA 문자열 반복.
            // N mod 3 == 2: f(1)과 f(2)를 B, A에 넣으면 나머지는 3개씩 그룹화 가능. BA 후 BBA 반복.
            // M mod 3 == 1: f(n)의 값이 f(1)부터 f(n - 1)까지의 합보다 1이 큼. 따라서 불가능.

            int N = Integer.parseInt(br.readLine());

            if (N % 3 == 1) {
                sb.append("impossible\n");

                continue;
            }

            if (N % 3 == 2) {
                sb.append("BA");
            }

            int repeat = N / 3;
//            sb.append("BBA".repeat(repeat)); // Java 11 이상 사용 가능.
            for (int i = 0; i < repeat; i++) {
                sb.append("BBA");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}
