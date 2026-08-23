public class PGM62048 {

    public long solution(int w, int h) {
        long width = (long) w;
        long height = (long) h;
        long gcdValue = gcd(width, height);

        return width * height - (width + height - gcdValue);
    }

    // 유클리드 호제법 이용 GCD(최대공약수) 구하기
    // 두 수 A와 B가 있을 때(A > B), A를 B로 나눈 나머지 R이 구하고자 하는 최대공약수 GCD(A, B)는 GCD(B, R)과 같다.
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}
