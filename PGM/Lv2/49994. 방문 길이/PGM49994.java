public class PGM49994 {
    public int solution(String dirs) {
        // UDRL 순서
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        boolean[][][] visited = new boolean[11][11][4]; // [x][y][dir]: (x, y)에서 dir 방향으로 이동했는지

        int x = 5;
        int y = 5;

        int answer = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);

            int dirIdx = 0;
            if(dir == 'U') {
                dirIdx = 0;
            } else if(dir == 'D') {
                dirIdx = 1;
            } else if(dir == 'L') {
                dirIdx = 2;
            } else if(dir == 'R') {
                dirIdx = 3;
            }

            int nextX = x + dx[dirIdx];
            int nextY = y + dy[dirIdx];

            if(nextX >= 0 && nextX < 11 && nextY >= 0 && nextY < 11) {
                if(!visited[x][y][dirIdx]) {
                    visited[x][y][dirIdx] = true;

                    // 출발지에서 가는 방향 방문 처리 했으면
                    // 도착지에서 오는 방향 방문 처리도

                    // XOR 연산을 통해 반대 방향 계산(UDLR 순서라 가능) (0 <-> 1, 2 <-> 3) (U <-> D, L <-> R)
                    int reverseDir = dirIdx ^ 1;
                    visited[nextX][nextY][reverseDir] = true;

                    answer++;
                }

                x = nextX;
                y = nextY;
            }
        }

        return answer;
    }

}
