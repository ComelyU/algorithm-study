public class PGM42842 {
//    // 완전탐색(Brute Force)
//    public int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//
//        // 전체 카펫의 격자 총합
//        int total = brown + yellow;
//
//        // 카펫의 최소 세로 길이는 3부터 시작.(위, 아래 갈색 테두리 + 내부 노란색 최소 1칸)
//        // 세로가 가로보다 커지지 않는 지점(제곱근)까지만 탐색
//        for (int height = 3; height * height <= total; height++) {
//            // 총합이 세로 길이로 나누어 떨어질 때만 가로 길이를 구함
//            if (total % height == 0) {
//                int width = total / height;
//
//                // 내부 노란색 격자의 수 = (가로 - 2) * (세로 - 2)
//                if ((width - 2) * (height - 2) == yellow) {
//                    answer[0] = width;
//                    answer[1] = height;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }

    // 근의 공식
    public int[] solution(int brown, int yellow) {
        // 가로 w, 세로 h
        // w * h = brown * yellow
        // 2w + 2h - 4 = brown (테두리 격자 수는 가장자리에서 중복되는 4칸 제외)
        // -> w + h = (brown + 4) / 2
        // w + h 와 w * h, 합과 곱을 알고 있음.
        // 따라서 t^2 - (w + h) + (w * h) = 0 이라는 이차방정식꼴로 계산 가능.
        // 문제 제한사항으로 w >= h
        // 따라서, 근의 공식 t = (-b +- sqrt(b^2 - 4ac)) / 2a 를 이용하면 (a는 t^2의 계수, b는 t의 계수, c는 상수)
        // w = (-b + sqrt(b^2 - 4ac)) / 2a, h = (-b - sqrt(b^2 - 4ac)) / 2a
        // a = 1, b = -((brown + 4) / 2), c = brown + yellow

        // 이차방정식 계수
        long a = 1, b = -((brown + 4) / 2), c = brown + yellow;

        // 판별식으로 루트 부분 도출
        long discriminant = b * b - 4 * a * c;
        double sqrtDiscriminant = Math.sqrt(discriminant);

        // 근의 공식 적용
        int width = (int) ((-b + sqrtDiscriminant) / (2 * a));
        int height = (int) ((-b - sqrtDiscriminant) / (2 * a));

        return new int[] {width, height};
    }

}
