public class PGM77885 {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if (num % 2 == 0) { // 짝수인 경우: num + 1
                answer[i] = num + 1;
            } else { // 홀수인 경우: 가장 오른쪽에 있는 0을 1로 변경 후 오른쪽 1을 0으로 변경.
                // 가장 오른쪽 0 비트 찾기. (가장 오른쪽 1 비트 찾기는 num & -num = num & ~(num + 1))
                long firstRightZero = ~num & (num + 1);

                answer[i] = (num | firstRightZero) & ~(firstRightZero >> 1);
            }
        }

        return answer;
    }

}
