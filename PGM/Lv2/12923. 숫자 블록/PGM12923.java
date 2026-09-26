public class PGM12923 {
    public int[] solution(long begin, long end) {
        // 위치 N에 놓이는 블록은 N의 약수 중 자기 자신을 제외한 가장 큰 수
        // 단, N이 1인 경우 깔 블록이 없어 0.

        int sectionSize = (int) (end - begin + 1);
        int[] section = new int[sectionSize];

        for (int i = 0; i < sectionSize; i++) {
            long pos = begin + i;
            section[i] = getMaxDivisor(pos);
        }

        return section;
    }

    private static int getMaxDivisor(long num) {
        if (num == 1) {
            return 0;
        }

        int maxDivisor = 1;
        long limit = (long) Math.sqrt(num);
        for (long i = 2; i <= limit; i++) { // i * i <= n, i <= n / i
            if (num % i == 0) {
                maxDivisor = (int) i;

                if (num / i <= 10_000_000) {
                    return (int) (num / i);
                }
            }
        }

        return maxDivisor;
    }
}
