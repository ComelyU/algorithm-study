public class PGM68646 {

    public int solution(int[] a) {
        int length = a.length;

        if (length <= 2) {
            return length;
        }

        int[] leftMins = new int[length];
        int[] rightMins = new int[length];

        int leftMin = a[0];
        for (int i = 0; i < length; i++) {
            leftMin = Math.min(leftMin, a[i]);
            leftMins[i] = leftMin;
        }

        int rightMin = a[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            rightMin = Math.min(rightMin, a[i]);
            rightMins[i] = rightMin;
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            // 좌우 최솟값이 모두 현재 값보다 작으면 터트릴 수 있음(남길 수 없음)
            if (leftMins[i] < a[i] && rightMins[i] < a[i]) {
                continue;
            }

            count++;
        }

        return count;
    }

}
