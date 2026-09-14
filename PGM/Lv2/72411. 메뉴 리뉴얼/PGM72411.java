import java.util.*;

public class PGM72411 {

    private static Map<String, Integer> courseMenuMap = new HashMap<>();
    private static int maxCount = 0;

    public String[] solution(String[] orders, int[] course) {
        List<String> courseResult = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order); // new String(order);
        }

        for (int length : course) {
            courseMenuMap.clear();
            maxCount = 0;

            for (String order : orders) {
                if (order.length() >= length) {
                    combination(new StringBuilder(), order, length, 0);
                }
            }

            for (String key : courseMenuMap.keySet()) {
                if (courseMenuMap.get(key) == maxCount && maxCount >= 2) {
                    courseResult.add(key);
                }
            }
        }

        Collections.sort(courseResult);

        return courseResult.toArray(new String[0]); // new String[courseResult.size()] 보다 빠르다고 함
    }

    private static void combination(StringBuilder sb, String order, int targetLength, int idx) {
        if (sb.length() == targetLength) {
            String result = sb.toString();
            courseMenuMap.put(result, courseMenuMap.getOrDefault(result, 0) + 1);
            maxCount = Math.max(maxCount, courseMenuMap.get(result));
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(sb, order, targetLength, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
