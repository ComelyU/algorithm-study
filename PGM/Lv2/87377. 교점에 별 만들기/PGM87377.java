import java.util.*;

public class PGM87377 {
    public String[] solution(int[][] line) {
        ArrayList<long[]> intersectionPointList = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        // 교점 계산
        for(int i = 0; i < line.length - 1; i++) {
            for(int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[j][0];
                long D = line[j][1];
                long E = line[i][2];
                long F = line[j][2];

                long denominator = A * D - B * C; // 교점 공식에서 분모. 즉, 나누는 수.
                if(denominator == 0) { // 두 직선이 평행하거나 일치하는 경우
                    continue;
                }

                long xNumerator = B * F - E * D; // 교점 공식에서 x의 분자. 즉, x를 구할 때 나누어지는 수
                long yNumerator = E * C - A * F; // 교점 공식에서 y의 분자. 즉, y를 구할 때 나누어지는 수

                if(xNumerator % denominator == 0 && yNumerator % denominator == 0) { // 나누었을 때 나머지가 0이면 정수 교점 발생.
                    long x = xNumerator / denominator;
                    long y = yNumerator / denominator;

                    intersectionPointList.add(new long[] {x, y});

                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        // 좌표계 생성 및 별 그리기
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] coordinateSystem = new char[height][width];
        for(int i = 0; i < height; i++) {
            Arrays.fill(coordinateSystem[i], '.');
        }

        for(long[] intersectionPoint : intersectionPointList) {
            int x = (int) (intersectionPoint[0] - minX);
            int y = (int) (maxY - intersectionPoint[1]);
            coordinateSystem[y][x] = '*';
        }

        // 결과
        String[] answer = new String[height];
        for(int i = 0; i < height; i++) {
            answer[i] = new String(coordinateSystem[i]);
        }

        return answer;
    }

}
