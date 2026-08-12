import java.util.*;

public class PGM155651 {

    // Prefix Sum (Imos Method)
    public int solution(String[][] book_time) {
        // 하루 최대 1440분 + 청소 시간 10분 + 버퍼 임의의 값으로 1450 이상의 배열 크기면 됨.
        int[] timeline = new int[1450];

        for (String[] bookTime : book_time) {
            int start = convertToMinute(bookTime[0]);
            int end = convertToMinute(bookTime[1]) + 10;

            timeline[start] += 1;
            timeline[end] -= 1;
        }

        int maxRoomCount = 0;
        int currentRoomCount = 0;

        for (int i = 0; i < timeline.length; i++) {
            currentRoomCount += timeline[i];
//            maxRoomCount = Math.max(maxRoomCount, currentRoomCount);
            if (currentRoomCount > maxRoomCount) {
                maxRoomCount = currentRoomCount;
            }
        }

        return maxRoomCount;
    }

    private static int convertToMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

//    // Priority Queue
//    public int solution(String[][] book_time) {
//        int[][] bookTimes = new int[book_time.length][2];
//
//        for(int i = 0; i < book_time.length; i++) {
//            bookTimes[i][0] = convertToMinute(book_time[i][0]);
//            bookTimes[i][1] = convertToMinute(book_time[i][1]) + 10;
//        }
//
//        Arrays.sort(bookTimes, (a, b) -> Integer.compare(a[0], b[0]));
////        Arrays.sort(bookTimes, Comparator.comparingInt(a -> a[0]));
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int[] bookTime : bookTimes) {
//            if (!pq.isEmpty() && pq.peek() <= bookTime[0]) {
//                pq.poll();
//            }
//
//            pq.offer(bookTime[1]);
//        }
//
//        return pq.size();
//    }
//
//    private static int convertToMinute(String time) {
//        String[] parts = time.split(":");
//        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
//    }

}
