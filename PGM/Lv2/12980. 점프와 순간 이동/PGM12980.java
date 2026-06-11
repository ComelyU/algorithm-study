import java.util.*;

public class PGM12980 {
    public int solution(int n) {
//        int battery = 0;
//
//        while(n != 0) {
//            if(n % 2 == 0) {
//                n /= 2;
//            } else {
//                n--;
//                battery++;
//            }
//        }
//
//        return battery;

        return Integer.bitCount(n);
    }

}
