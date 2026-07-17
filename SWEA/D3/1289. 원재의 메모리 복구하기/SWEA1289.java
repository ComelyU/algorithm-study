import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1289 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            char[] memoryValue = br.readLine().toCharArray();

            int editCount = 0;
            char currentValue = '0'; // 초기화 상태에서는 모든 bit가 0
            for(int i = 0; i < memoryValue.length; i++) {
                char targetValue = memoryValue[i];
                if(targetValue != currentValue) {
                    editCount++;
                    currentValue = targetValue;
                }
            }

            sb.append('#').append(testCase).append(' ').append(editCount).append('\n');
        }

        System.out.println(sb.toString());
    }

}
