public class PGM43105 {
    public int solution(int[][] triangle) {
        // Bottom-up. Top-down 방식은 인덱스에 따른 조건 (예외) 처리가 필요. 따라서, Bottom-up 적용
        for(int i = triangle.length - 2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]); // 아래칸의 인접한 두 수 중 큰 값을 현재 수에 더함
            }
        }

        return triangle[0][0];

//        // Top-dwon
//        for(int i = 1; i < triangle.length; i++) {
//            for(int j = 0; j < triangle[i].length; j++) {
//                if(j == 0) {
//                    triangle[i][j] += triangle[i - 1][j];
//                } else if(j == triangle[i].length - 1) {
//                    triangle[i][j] += triangle[i - 1][j - 1];
//                } else {
//                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
//                }
//            }
//        }
//
//        int maxSum = 0;
//        int lastRow = triangle.length - 1;
//        int lastRowLength = triangle[lastRow].length;
//        for(int i = 0; i < lastRowLength; i++) {
//            maxSum = Math.max(maxSum, triangle[lastRow][i]);
//        }
//
//        return maxSum;
    }

}
