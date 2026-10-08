public class PGM12920 {

    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        // 이분 탐색(Binary Search) 범위 정의 (시간 기준)
        int low = 1;
        int high = 0;

        // 코어 중 가장 처리 시간이 긴 코어를 기준으로 최대 시간 예측
        for (int core : cores) {
            high = Math.max(high, core);
        }
        high *= n;

        int time = 0;
        int totalWork = 0;

        // Lower Bound로 n개 이상의 작업을 처리할 수 있는 최소 시간(time)을 구하기
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countCalculatedWork(mid, cores);

            if (count >= n) {
                time = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // 찾은 최소 시간의 직전 시간까지 완료된 총 작업량 계산
        totalWork = countCalculatedWork(time - 1, cores);

        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) { // 코어가 빈 경우
                totalWork++;

                if (totalWork == n) {
                    return i + 1; // 코어는 1번부터 시작
                }
            }
        }


        return -1; // 도달하지 않음
    }

    // 특정 시간(time)까지 모든 코어가 처리할 수 있는 누적 작업량 계산
    private int countCalculatedWork(int time, int[] cores) {
        if (time < 0) {
            return 0;
        }

        int count = cores.length; // 0초에 모든 코어가 1개씩 처리하고 시작
        for (int core : cores) {
            count += time / core;
        }

        return count;
    }

}
