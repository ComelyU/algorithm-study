public class PGM87389 {
    public int solution(int n) {
//        int limit = (int) Math.sqrt(n);
//        for(int i = 2; i <= limit; i++) {
//            if(n % i == 1) {
//                return i;
//            }
//        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 1) {
                return i;
            }
        }

        return n - 1;
    }

}
