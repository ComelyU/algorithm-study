public class PGM389478 {
    // 수식 활용
    public int solution(int n, int w, int num) {
        int count = 0;

        // 꺼내려는 택배 상자의 위치 구하기
        int targetRow = (num - 1) / w;
        int targetColumn = getColumn(num, w, targetRow);

        // 전체 택배의 최고 층 구하기
        int maxRow = (n - 1) / w;

        for(int row = targetRow; row <= maxRow; row++) {
            // 현재 행(층)에서 꺼내려는 택배가 있는 열(targetColumn)에 해당하는 택배 번호 역으로 계산
            int currentNum = getNumberByPosition(row, targetColumn, w);

            // 구한 택배 번호가 전체 택배 개수인 n 이하이면 존재하는 택배
            if(currentNum <= n) {
                count++;
            }
        }

        return count;
    }

    // 행, 열, 각 행의 택배 상자의 수를 통해 택배 번호를 구하기
    private int getNumberByPosition(int row, int column, int w) {
        if(row % 2 == 0) {
            return row * w + column + 1;
        } else {
            return row * w + w - column; // w - column = (w - 1 - column) + 1
        }
    }

    // 택배 번호를 통해 열(Column)의 위치를 구하기
    private int getColumn(int num, int w, int row) {
        int remainder = (num - 1) % w;

        if(row % 2 == 0) {
            return remainder;
        } else {
            return w - 1 - remainder;
        }
    }

//    // 배열 활용
//    public int solution(int n, int w, int num) {
//        int maxRow = (n + w - 1) / w;
//        int[][] boxes = new int[maxRow][w];
//
//        // 지그재그 패턴으로 배열에 택배 번호 채우기
//        int boxNumber = 1;
//        int targetRow = 0;
//        int targetColumn = 0;
//        for(int row = 0; row < maxRow; row++) {
//            if(row % 2 == 0) {
//                // 짝수 행(층): 좌 to 우
//                for(int column = 0; column < w; column++) {
//                    if(boxNumber <= n) {
//                        boxes[row][column] = boxNumber;
//
//                        if(boxNumber == num) {
//                            targetRow = row;
//                            targetColumn = column;
//                        }
//
//                        boxNumber++;
//                    }
//                }
//            } else {
//                // 홀수 행(층): 우 to 좌
//                for(int column = w - 1; column >= 0; column--) {
//                    if(boxNumber <= n) {
//                        boxes[row][column] = boxNumber;
//
//                        if(boxNumber == num) {
//                            targetRow = row;
//                            targetColumn = column;
//                        }
//
//                        boxNumber++;
//                    }
//                }
//            }
//        }
//
//        int count = 0;
//        for(int row = targetRow; row < maxRow; row++) {
//            if(boxes[row][targetColumn] != 0) {
//                count++;
//            }
//        }
//
//        return count;
//    }
}
