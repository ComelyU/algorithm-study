import java.util.*;

public class PGM12906 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(arr.length);

//        // prev 사용
//        int prevElement = -1; // 배열의 각 원소는 0~9이므로 초기값은 0~9를 제외한 임의의 값으로 설정.
//        for(int element : arr) {
//            if(element != prevElement) {
//                list.add(element);
//                prevElement = element;
//            }
//        }

        // list.get(list.size() - 1) 사용
        for(int element : arr) {
            if(list.isEmpty() || list.get(list.size() - 1) != element) {
                list.add(element);
            }
        }

        // List to int[] 변환
//        // 가독성, 간결성
//        return list.stream().mapToInt(Integer::intValue).toArray();
        // 효율성
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}
