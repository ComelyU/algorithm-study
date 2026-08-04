public class PGM148653 {

    public int solution(int storey) {
        int minSorcererStones = 0;

        // 1의 자리 추출: storey % 10을 통해 현재 자릿수의 값을 구하고 storey / 10으로 다음 자릿수로 넘어감.
        // 1의 자리가 5 초과인 경우: 6 ~ 9의 값은 빼는 것보다 올려서 다음 자릿수에 1을 더해주는 것이 유리.
        // 1의 자리가 5와 같거나 작은 경우: 5일 때는 바로 앞 자릿수가 5 이상이면 올림을 선택하고, 5 미만이면 내림을 선택해 최소 횟수를 맞춤.

        while (storey > 0) {
            int remainder = storey % 10;
            storey /= 10;

            if (remainder > 5 || (remainder == 5 && storey % 10 >= 5)) {
                minSorcererStones += (10 - remainder);
                storey++;
            } else {
                minSorcererStones += remainder;
            }
        }

        return minSorcererStones;
    }

}
