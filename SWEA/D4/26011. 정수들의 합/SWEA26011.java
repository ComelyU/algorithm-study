import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA26011 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long tuple4Count = 0; // 4-tuple = quadruple

            // a + b는 2부터 2 * N까지 가능
            // a + b - c - d = K에서 이항정리를 통해
            // a + b = K + (c + d)
            // c + d도 2부터 2 * N까지 가능
            // 따라서, a + b는 2 + K부터 2 * N + K까지 가능
            // a + b가 가능한 값은 2와 2 + K 중 큰 값부터 2 * N과 2 * N + K 중 작은 값까지
            int startAB = Math.max(2, 2 + K);
            int endAB = Math.min(2 * N, 2 * N + K);

            for (int plusAB = startAB; plusAB <= endAB; plusAB++) {
                int plusCD = plusAB - K;

                if (plusCD >= 2 && plusCD <= 2 * N) {
                    tuple4Count += getTuple2Count(plusAB, N) * getTuple2Count(plusCD, N);
                }
            }

            sb.append(tuple4Count).append('\n');
        }

        System.out.println(sb.toString());
    }

    // 1 이상 limitNum 이하의 두 수의 합이 targetSum이 되는 쌍(2-tuple = pair)의 개수를 구하기
    private static long getTuple2Count(int targetSum, int limitNum) {
        if (targetSum < 2 || targetSum > 2 * limitNum) {
            return 0;
        }

        if (targetSum <= limitNum + 1) {
            // [상한선 미달] targetSum이 limitNum + 1 이하일 때는 최댓값(limitNum) 제약에 걸리지 않음
            // 1부터 targetSum - 1까지 모든 조합이 유효하므로 총 개수는 targetSum - 1
            return targetSum - 1;
        } else {
            // [여사건 원리] 상한선 제약으로 인해 불가능한 조합을 전체에서 빼는 방식으로 계산
            // [전체 쌍 계산] 수의 상한선 제약이 없을 때의 이론상 전체 조합: targetSum - 1
            // [탈락자 계산] 한쪽 수가 limitNum을 초과해 불가능한 조합: targetSum - 1 - limitNum (x, y 각각 존재하므로 * 2)
            // [차감 및 식 정리] 전체 쌍 - 탈락자 쌍 = (targetSum - 1) - 2 * (targetSum - 1 - limitNum)
            // = targetSum - 1 - 2 * targetSum + 2 + 2 * limitNum
            // = 2 * limitNum - targetSum + 1
            return 2L * limitNum - targetSum + 1; // 2L * limitNum - (targetSum - 1)
        }
    }

}
