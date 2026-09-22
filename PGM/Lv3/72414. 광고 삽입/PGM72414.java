import java.util.*;

public class PGM72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeFormatToSeconds(play_time);
        int advTime = timeFormatToSeconds(adv_time);

        // Prefix Sum with IMOS Method.
        long[] timelines = new long[playTime + 1];

        for (String log : logs) {
//            String[] split = log.split("-");
//            int start = timeFormatToSeconds(split[0]);
//            int end = timeFormatToSeconds(split[1]);
            StringTokenizer st = new StringTokenizer(log, "-");
            int start = timeFormatToSeconds(st.nextToken());
            int end = timeFormatToSeconds(st.nextToken());

            timelines[start]++;
            timelines[end]--;
        }

        // First Prefix Sum: Concurrent Viewers at i (s)
        for (int i = 1; i <= playTime; i++) {
            timelines[i] += timelines[i - 1];
        }

        // Second Prefix Sum: 0 ~ i (s) total Viewers
        for (int i = 1; i <= playTime; i++) {
            timelines[i] += timelines[i - 1];
        }

        // Searching with Sliding Window.
        long maxViewerCount = timelines[advTime - 1]; // If advTime is 3 then index 0 ~ 2 is used.
        int startTime = 0;

        for (int i = advTime; i <= playTime; i++) {
            long viewerCount = timelines[i] - timelines[i - advTime];

            if (viewerCount > maxViewerCount) {
                maxViewerCount = viewerCount;
                startTime = i - advTime + 1; // i - (advTime - 1)
            }
        }

        return secondsToTimeFormat(startTime);
    }

    private static int timeFormatToSeconds(String timeFormat) {
        String[] parts = timeFormat.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        return hour * 3600 + minute * 60 + second;
    }

    private static String secondsToTimeFormat(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds % 3600) / 60;
        int second = seconds % 60;

//        StringBuilder formattedTime = new StringBuilder();
//
//        if (hour < 10) {
//            formattedTime.append('0');
//        }
//        formattedTime.append(hour).append(':');
//
//        if (minute < 10) {
//            formattedTime.append('0');
//        }
//        formattedTime.append(minute).append(':');
//
//        if (second < 10) {
//            formattedTime.append('0');
//        }
//        formattedTime.append(second);
//
//        return formattedTime.toString();

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
