import java.util.*;

public class PGM64065 {

    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).split("},\\{"); // "\\},\\{"가 안전하긴 함

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        Set<Integer> set = new LinkedHashSet<>(); // HashMap 사용하여 빈도수 체크해도 됨

        for (String str : arr) {
            String[] nums = str.split(",");

            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;

        for (int num : set) {
            answer[index++] = num;
        }

        return answer;
    }

}
