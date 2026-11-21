import java.util.*;

public class PGM81302 {

    // [방식 1] 응시자('P') 쌍별 맨해튼 거리 및 상대 위치 오프셋 체크
    // 시간 복잡도: 대기실당 O(K ^ 2) (K = 응시자 수 <= 25) | 공간 복잡도: O(K)
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isSafeRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean isSafeRoom(String[] room) {
        List<int[]> pList = new ArrayList<>();

        // 1. 행·열 순서대로 'P' 좌표 수집 (자동으로 오름차순 정렬됨)
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (room[r].charAt(c) == 'P') {
                    pList.add(new int[]{r, c});
                }
            }
        }

        // 2. 두 응시자 쌍(i < j) 비교: 정렬되어 있으므로 아래쪽·오른쪽 방향만 검사
        for (int i = 0; i < pList.size() - 1; i++) {
            for (int j = i + 1; j < pList.size(); j++) {
                int[] p1 = pList.get(i);
                int[] p2 = pList.get(j);
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                if (dist > 2) {
                    continue;
                }
                if (dist == 1) {
                    return false; // 맨해튼 거리 1이면 무조건 위반
                }

                // 거리 2인 경우: 4가지 상대 위치에 따른 파티션('X') 유무 확인
                int r1 = p1[0], c1 = p1[1];
                int r2 = p2[0], c2 = p2[1];

                if (r1 == r2 && c2 == c1 + 2) {
                    if (room[r1].charAt(c1 + 1) != 'X') {
                        return false; // 가로 2칸 사이
                    }
                } else if (c1 == c2 && r2 == r1 + 2) {
                    if (room[r1 + 1].charAt(c1) != 'X') {
                        return false; // 세로 2칸 사이
                    }
                } else if (r2 == r1 + 1 && c2 == c1 - 1) {
                    if (room[r1 + 1].charAt(c1) != 'X' || room[r1].charAt(c1 - 1) != 'X') {
                        return false; // 왼쪽 아래 대각선
                    }
                } else {
                    if (room[r1 + 1].charAt(c1) != 'X' || room[r1].charAt(c1 + 1) != 'X') {
                        return false; // 오른쪽 아래 대각선
                    }
                }
            }
        }

        return true;
    }

//    // [방식 2] 최대 거리 2 제한 BFS 탐색
//    // 시간 복잡도: 대기실당 O(N ^ 2 * K) (N = 5, 상수 시간) | 공간 복잡도: O(N ^ 2)
//    private static final int[] DR = {-1, 1, 0, 0};
//    private static final int[] DC = {0, 0, -1, 1};
//
//    public int[] solution(String[][] places) {
//        int[] answer = new int[places.length];
//
//        for (int i = 0; i < places.length; i++) {
//            answer[i] = isSafeRoom(places[i]) ? 1 : 0;
//        }
//
//        return answer;
//    }
//
//    private boolean isSafeRoom(String[] room) {
//        for (int r = 0; r < 5; r++) {
//            for (int c = 0; c < 5; c++) {
//                if (room[r].charAt(c) == 'P' && !bfs(r, c, room)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    // 시작점 (startR, startC)에서 맨해튼 거리 2 이내에 파티션 없는 'P' 탐색
//    private boolean bfs(int startR, int startC, String[] room) {
//        Deque<int[]> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[5][5];
//
//        queue.offer(new int[]{startR, startC, 0});
//        visited[startR][startC] = true;
//
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            int r = curr[0], c = curr[1], dist = curr[2];
//
//            if (dist >= 2) {
//                continue; // 거리 2 이상은 더 탐색할 필요 없음
//            }
//
//            for (int d = 0; d < 4; d++) {
//                int nr = r + DR[d];
//                int nc = c + DC[d];
//
//                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) {
//                    continue;
//                }
//                if (room[nr].charAt(nc) == 'X') {
//                    continue; // 파티션('X')은 이동 불가
//                }
//                if (room[nr].charAt(nc) == 'P') {
//                    return false; // 거리 2 이내 다른 응시자 발견 시 위반
//                }
//
//                visited[nr][nc] = true;
//                queue.offer(new int[]{nr, nc, dist + 1});
//            }
//        }
//
//        return true;
//    }

}
