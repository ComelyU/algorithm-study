import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class SWEA1928 {

//    // Base64 라이브러리 사용
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int testCase = 1; testCase <= T; testCase++) {
//            String encodedStr = br.readLine();
//
//            String decodedStr = new String(Base64.getDecoder().decode(encodedStr));
//
//            sb.append('#').append(testCase).append(' ').append(decodedStr).append('\n');
//        }
//
//        System.out.println(sb);
//    }

    // 직접 구현
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String encodedStr = br.readLine();

            String decodedStr = decodeBase64(encodedStr);

            sb.append('#').append(testCase).append(' ').append(decodedStr).append('\n');
        }

        System.out.println(sb);
    }

    private static String decodeBase64(String encodedStr) {
        StringBuilder str = new StringBuilder();
        int bufferBits = 0;
        int bufferCount = 0;

        for (int i = 0; i < encodedStr.length(); i++) {
            int value = getBase64Value(encodedStr.charAt(i));

            bufferBits = (bufferBits << 6) | value;
            bufferCount++;

            if (bufferCount == 4) {
                str.append((char) ((bufferBits >> 16) & 0xFF)); // 상위 8비트
                str.append((char) ((bufferBits >> 8) & 0xFF)); // 중간 8비트
                str.append((char) (bufferBits & 0xFF)); // 하위 8비트

                bufferBits = 0;
                bufferCount = 0;
            }
        }

        return str.toString();
    }

    private static int getBase64Value(char c) {
        if (c >= 'A' && c <= 'Z')
            return c - 'A';
        else if (c >= 'a' && c <= 'z')
            return c - 'a' + 26;
        else if (c >= '0' && c <= '9')
            return c - '0' + 52;
        else if (c == '+')
            return 62;
        else // c == '/'
            return 63;
    }


}
