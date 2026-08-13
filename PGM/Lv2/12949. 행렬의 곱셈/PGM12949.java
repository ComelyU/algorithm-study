public class PGM12949 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int frontLen = arr1.length;
        int midLen = arr2.length; // arr2.length == arr1[0].length
        int backLen = arr2[0].length;

        int[][] answer = new int[frontLen][backLen];

        for (int i = 0; i < frontLen; i++) {
            for (int j = 0; j < backLen; j++) {
                for (int k = 0; k < midLen; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

}
