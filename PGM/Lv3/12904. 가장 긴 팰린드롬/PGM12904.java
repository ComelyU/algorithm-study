public class PGM12904 {

    public int solution(String s) {
        int length = s.length();

        for (int len = length; len > 1; len--) {
            for (int start = 0; start <= length - len; start++) {
                int end = start + len - 1;
                if (isPalindrome(s, start, end)) {
                    return len;
                }
            }
        }

        return 1;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

}
