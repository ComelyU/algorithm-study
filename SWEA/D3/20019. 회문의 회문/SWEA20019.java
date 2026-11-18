import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA20019 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine().trim();
            int len = s.length();
            int mid = len / 2;

            // 전체 문자열 s가 이미 회문이라면, 앞부분(0 ~ mid - 1)과 뒷부분(mid + 1 ~ len - 1)은 서로 뒤집힌 상태
            // 앞부분만 회문인지 확인하면 뒷부분은 자동으로 회문이 보장
            boolean isDoublePalindrome = isPalindrome(s, 0, len - 1)
                && isPalindrome(s, 0, mid - 1);
//                && isPalindrome(s, mid + 1, len - 1);

            sb.append('#').append(tc).append(' ')
                .append(isDoublePalindrome ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

}
