public class PGM12924 {

    public int solution(int n) {
        int answer = 1;

        int limit = n / 2;

        for (int i = 1; i <= limit; i++) {
            int sum = 0;

            for (int j = i; j <= limit + 1; j++) {
                sum += j;

                if (sum > n) {
                    break;
                }

                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }


        return answer;
    }

}
