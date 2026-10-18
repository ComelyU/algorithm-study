import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1153 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            int maxLength = 1;
            int currentLength = 1;

            for (int j = 1; j < input.length(); j++) {
                if (input.charAt(j) == input.charAt(j - 1)) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
            maxLength = Math.max(maxLength, currentLength);

            sb.append(maxLength).append('\n');
        }

        System.out.println(sb);
    }
}
