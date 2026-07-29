import java.util.*;

public class PGM152995 {

    public int solution(int[][] scores) {
        // 완호의 점수
        int wanhoAttendanceScore = scores[0][0];
        int wanhoPeerScore = scores[0][1];
        int wanhoSumScore = wanhoAttendanceScore + wanhoPeerScore;

        Arrays.sort(scores, (a,b) -> {
            if (a[0] == b[0]) { // 근무 태도 점수가 같으면
                // 동료 평가 점수 오름차순 정렬
                return Integer.compare(a[1], b[1]);
//                return a[1] - b[1];
            }

            // 근무 태도 점수 내림차순 정렬
            return Integer.compare(b[0], a[0]);
//            return b[0] - a[0];
        });

        int maxPeerScore = 0;
        int wanhoRank = 1;

        for (int[] score : scores) {
            if (score[1] < maxPeerScore) { // 동료 평가 점수가 이전 최댓값보다 작은 경우 인센티브 대상 아님(근무 태도 점수가 내림차순이기 때문)
                // 완호가 인센티브 제외 대상인가
                if (score[0] == wanhoAttendanceScore && score[1] == wanhoPeerScore) {
                    return -1;
                }
            } else { // 인센티브 대상
                // 동료 평가 점수 최댓값 갱신
                maxPeerScore = Math.max(maxPeerScore, score[1]);

                if(score[0] + score[1] > wanhoSumScore) { // 완호보다 점수의 합이 큼.(= 완호보다 높은 순위)
                    wanhoRank++;
                }
            }
        }

        return wanhoRank;
    }

}
