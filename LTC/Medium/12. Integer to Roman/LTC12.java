import java.util.*;

public class LTC12 {

    // Array
    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);

                num -= values[i];
            }
        }

        return roman.toString();
    }

//    // Hash Table OR Binary Tree
//    public String intToRoman(int num) {
////        final Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
//        final Map<Integer, String> map = new LinkedHashMap<>();
//
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");
//
//        StringBuilder roman = new StringBuilder();
//
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            while (num >= entry.getKey()) {
//                roman.append(entry.getValue());
//                num -= entry.getKey();
//            }
//        }
//
////        for (int value : map.keySet()) {
////            while (num >= value) {
////                roman.append(map.get(value));
////                num -= value;
////            }
////        }
//
//        return roman.toString();
//    }

}
