public class LTC8 {
    public int myAtoi(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int length = s.length();

        // Ignore any leading whitespace (" ").
        while(index < length && s.charAt(index) == ' ') {
            index++;
        }

        // string is empty after removing leading whitespace
        if(index == length) {
            return 0;
        }

        // Determine sign (+ or -)
        int sign = 1;
        int firstCharacter = s.charAt(index);
        if(firstCharacter == '+') {
            index++;
        } else if(firstCharacter == '-') {
            sign = -1;
            index++;
        }

        // Conversion And Rounding(handling overflow)
        int result = 0;
        while(index < length) {
            int digit = s.charAt(index) - '0';

            if(digit < 0 || digit > 9) {
                break;
            }

            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

}
