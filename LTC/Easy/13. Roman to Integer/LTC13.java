import java.util.*;

public class LTC13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int num = 0;
        int sLength = s.length();

        for (int i = 0; i < sLength; i++) {
            int currentValue = map.get(s.charAt(i));

            if (i < sLength - 1 && currentValue < map.get(s.charAt(i + 1))) { // exist next char and current value is less than next value
                num -= currentValue;
            } else {
                num += currentValue;
            }
        }

        return num;
    }

}
