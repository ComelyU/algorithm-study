public class PGM12911 {
    // 내장 method 사용
    public int solution(int n) {
        int nBitCount = Integer.bitCount(n);

        while(true) {
            n++;

            if(Integer.bitCount(n) == nBitCount) {
                return n;
            }
        }
    }

//    // Shift 연산 (비트 연산) 이용
//    public int solution(int n) {
//        int nBitCount = getBitCount(n);
//
//        while(true) {
//            n++;
//
//            if(getBitCount(n) == nBitCount) {
//                return n;
//            }
//        }
//    }
//
//    private int getBitCount(int num) {
//        int count = 0;
//        while(num != 0) {
////            count += (num & 1); // 마지막 비트가 1인지 확인. (num % 2 == 1).
////            num >>>= 1; // 오른쪽으로 1비트 이동. (부호 없는 시프트). num이 1,000,000 이하의 자연수라 부호 있는 시프트인 >> 를 사용해도 무방.
//            num = num & (num - 1); // n & (n - 1) 기법. 가장 오른쪽에 있는 1을 지워버리기.
//            count++;
//        }
//
//        return count;
//    }
}
