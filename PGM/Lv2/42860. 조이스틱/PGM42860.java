public class PGM42860 {
    public int solution(String name) {
        int nameLength = name.length();
        int moveLeftRight = nameLength - 1; // 좌우 이동(조작) 횟수. Initial Value는 우측으로만 이동했을 때의 좌우 이동 수.
        int moveUpDown = 0; // 상하 이동(조작) 횟수.

        for (int idx = 0; idx < nameLength; idx++) {
            // 상하 이동(조작) 횟수.
            char c = name.charAt(idx);
            moveUpDown += Math.min(c - 'A', 'Z' - c + 1);

            // 좌우 이동(조작) 횟수 최솟값 계산. 즉, 연속된 A 처리.
            int nextIdx = idx + 1;
            while (nextIdx < nameLength && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            // 우측 이동(조작)을 정방향, 좌측 이동(조작)을 역방향이라고 하면 Greedy하게
            // [경로 A] 순서대로 정방향으로만 이동(조작) 횟수. 또는 갱신된 경로에 따른 최솟값.
            // = 초기의 moveLeftRight. 이후에는 최솟값으로 갱신된 값.
            // [경로 B] idx까지 정방향 진행 후 바로 뒤 연속된 A 구간을 건너뛰기 위해 역방향 진행하는 경우
            // = idx * 2 + (nameLength - nextIdx)
            // [경로 C] 처음부터 역방향 진행해서 nextIdx까지 해결 후 다시 정방향으로 idx까지 진행하는 경우
            // = (nameLength - nextIdx) * 2 + idx
            // 3가지 비교 후 최솟값을 선택
            moveLeftRight = Math.min(moveLeftRight, Math.min(idx * 2 + (nameLength - nextIdx), (nameLength - nextIdx) * 2 + idx));
        }

        return moveUpDown + moveLeftRight;
    }
}
