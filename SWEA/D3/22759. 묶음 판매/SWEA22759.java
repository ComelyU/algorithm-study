import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA22759 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

//            boolean isExist = checkByBinarySearch(L, R);

            /*
            1. 구간 길이 제한 (하한 설정)
                X로 나눈 나머지가 절반 이상이 되는 연속된 정수는 최대 floor(X / 2)개
                따라서, 구간의 길이(R - L + 1)는 floor(X / 2) 이하
                R - L + 1 <= X / 2
            2. 최솟값 L 조건 (상한 설정)
                X > L일 때 L % X = L. L >= ceil(X / 2)를 만족하려면 X <= 2 * L
                (X <= L이면 구간 내에 X의 배수(= 나머지가 0)가 포함될 확률이 커짐)
            3. 유효한 X의 존재 범위 계산
                2 * (R - L + 1) <= X <= 2 * L
                위 부등식이 성립하려면 하한 <= 상한
                2 * (R - L + 1) <= 2 * L
                R - L + 1 <= L
                R <= 2 * L - 1
                정수 범위라 R < 2 * L
            */
            boolean isExist = R < (L * 2);

            sb.append(isExist ? "yes\n" : "no\n");
        }

        System.out.print(sb);
    }

    // 이분 탐색(Binary Search)
    private static boolean checkByBinarySearch(int L, int R) {
        // X가 L 이하: L 또는 그 근처에서 나머지가 0이 되는 지점이 발생하기 쉬움
        // X가 2L을 초과: L % X < X / 2가 되어 조건을 만족할 수 없음
        int low = L + 1;
        int high = L * 2;

        while (low <= high) {
            // mid는 찾는 묶음의 단위 X
            // 논리 시프트 사용. (low, high가 모두 양수라 가능)
            // 대신, low + (high - low) / 2 사용하거나 long으로 해서 계산해도 됨.
            int mid = (low + high) >>> 1;

            // 묶음 제품을 구매하는 것이 나을 수 있는 기준이 되는 단제품의 수
            // Math.ceil(mid / 2.0)도 가능.
            int half = (mid + 1) / 2;

            // [L, R] 구간 내에 모든 수가 mid로 나눈 몫이 같고
            // 최솟값 L의 나머지가 half 이상인 경우
            if (L / mid == R / mid && (L % mid) >= half) {
                return true;
            }

            // R이 다음 몫으로 넘어간 경우
            if (L / mid < R / mid) {
                low = mid + 1;
            } else { // 몫은 같지만 L % mid < half인 경우
                high = mid - 1;
            }
        }

        return false;
    }

}
