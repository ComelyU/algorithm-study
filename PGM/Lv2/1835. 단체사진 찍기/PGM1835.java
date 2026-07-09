public class PGM1835 {
    private static final int FRIEND_COUNT = 8;

    private static int[] friend1s; // data에서 친구1
    private static int[] friend2s; // data에서 친구2
    private static int[] operands; // data에서 친구1, 친구2 사이 조건
    private static int[] distances; // data에서 친구1, 친구2 사이 거리

    private static boolean[] visited;
    private static int[] positions; // 각 친구가 줄에서 몇 번째에 위치하는지 (idx가 친구를 의미, value가 위치를 의미)

    private static int count;

    public int solution(int n, String[] data) {
        count = 0;

        friend1s = new int[n];
        friend2s = new int[n];
        operands = new int[n];
        distances = new int[n];

        for(int i = 0; i < n; i++) {
            friend1s[i] = getFriend1Idx(data[i].charAt(0));
            friend2s[i] = getFriend1Idx(data[i].charAt(2));
            operands[i] = data[i].charAt(3);
//            distances[i] = Integer.parseInt(data[i].charAt(4) + "");
            distances[i] = data[i].charAt(4) - '0' + 1; // 거리가 a이면 인덱스 차이는 a + 1
        }

        visited = new boolean[FRIEND_COUNT];
        positions = new int[FRIEND_COUNT];

        dfs(0, n);

        return count;
    }

    private static void dfs(int depth, int n) {
        if(!isPossible(n)) {
            return;
        }

        if(depth == FRIEND_COUNT) {
            count++;
            return;
        }

        for(int i = 0; i < FRIEND_COUNT; i++) {
            if(!visited[i]) {
                visited[i] = true;
                positions[i] = depth;

                dfs(depth + 1, n);

                visited[i] = false;
            }
        }
    }

    // 줄 세우는 도중 실시간 조건 체크
    private static boolean isPossible(int n) {
        for(int i = 0; i < n; i++) {
            int friend1 = friend1s[i];
            int friend2 = friend2s[i];

            // 위 두 친구가 모두 줄에 서 있는 경우에만 체크
            if(visited[friend1] && visited[friend2]) {
                int operand = operands[i];
                int distance = distances[i];
                int positionDistance = Math.abs(positions[friend1] - positions[friend2]);

                if(operand == '=' && positionDistance != distance) {
                    return false;
                }
                if(operand == '>' && positionDistance <= distance) {
                    return false;
                }
                if(operand == '<' && positionDistance >= distance) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getFriend1Idx(char friend) {
        return switch(friend) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'F' -> 2;
            case 'J' -> 3;
            case 'M' -> 4;
            case 'N' -> 5;
            case 'R' -> 6;
            case 'T' -> 7;
            default -> -1;
        };
    }
}
