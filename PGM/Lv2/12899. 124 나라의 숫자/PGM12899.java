public class PGM12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        char[] numTableByRemainder = {'4', '1', '2'}; // 3으로 나눈 나머지 대응 (0 -> 4, 1 -> 1, 2 -> 2)

        while(n > 0) {
            int remainder = n % 3;
            n /= 3;

            // 나머지가 0인 경우(3의 배수), 124 나라에서는 4로 표현
            // 몫을 1 줄여주어야 올바른 124 나라의 3진법 변환
            if(remainder == 0) {
                n--;
            }

            sb.append(numTableByRemainder[remainder]);
        }

        return sb.reverse().toString();
    }

}
