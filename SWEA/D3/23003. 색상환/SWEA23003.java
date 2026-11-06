import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
import java.util.StringTokenizer;

public class SWEA23003 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//        Map<String, Integer> colorMap = new HashMap<>(); // color, index (CCW, counterclockwise)
//        colorMap.put("red", 0);
//        colorMap.put("orange", 1);
//        colorMap.put("yellow", 2);
//        colorMap.put("green", 3);
//        colorMap.put("blue", 4);
//        colorMap.put("purple", 5);

        final char EQUAL = 'E'; // 같은 색
        final char ADJACENT = 'A'; // 인접한 색
        final char COUNTER = 'C'; // 반대에 있어 마주보는 색
        final char OTHERWISE = 'X'; // 위의 세 경우가 아닌 경우

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

//            int colorIndex1 = colorMap.get(st.nextToken());
//            int colorIndex2 = colorMap.get(st.nextToken());

            int colorIndex1 = getColorIndex(st.nextToken());
            int colorIndex2 = getColorIndex(st.nextToken());

            int diff = Math.abs(colorIndex1 - colorIndex2);
            if (diff == 0) {
                sb.append(EQUAL).append('\n');
            } else if (diff == 1 || diff == 5) {
                sb.append(ADJACENT).append('\n');
            } else if (diff == 3) {
                sb.append(COUNTER).append('\n');
            } else {
                sb.append(OTHERWISE).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int getColorIndex(String color) {
        // (CCW, counterclockwise)
        switch (color) {
            case "red": return 0;
            case "orange": return 1;
            case "yellow": return 2;
            case "green": return 3;
            case "blue": return 4;
            case "purple": return 5;
            default: return -1;
        }
    }

}
