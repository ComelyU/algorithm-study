import java.util.*;

public class PGM42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        while(left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람이 같이 탈 수 있는 경우
            // -> 두 사람 다 탑승
            // 그렇지 않은 경우
            // -> 무거운 사람만 탑승
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }

            answer++;
        }

        return answer;
    }

}
