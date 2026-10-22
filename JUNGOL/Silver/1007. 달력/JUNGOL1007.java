import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1007 {

    // 평년 기준 각 월별 최대 일 수
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] DAY_NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int year = 0;
        int month = 0;
        int day = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());

            if (isValid(year, month, day)) {
                break;
            }

            sb.append("INPUT ERROR!\n");
        }

        int totalDays = getTotalDays(year, month, day);
        int tagetDayNameIndex = (totalDays + 6) % 7;

        int firstDayTotalDays = totalDays - (day - 1);
        int firstDayNameIndex = (firstDayTotalDays + 6) % 7;

        sb.append(year).append(". ").append(month).append('\n');
        sb.append("sun mon tue wed thu fri sat\n");

        for (int i = 0; i < firstDayNameIndex; i++) {
            sb.append("    ");
        }

        int maxDay = getDaysInMonth(year, month);
        int currentDay = firstDayNameIndex;

        for (int d = 1; d <= maxDay; d++) {
            if (d < 10) {
                sb.append("  ");
            } else {
                sb.append(' ');
            }
            sb.append(d);

            currentDay++;
            if (currentDay == 7) {
                sb.append('\n');
                currentDay = 0;
            } else {
                sb.append(' ');
            }
        }

        if (currentDay != 0) {
            sb.append('\n');
        }

        sb.append(DAY_NAMES[tagetDayNameIndex]).append('\n');

        System.out.println(sb);
    }

    private static int getTotalDays(int year, int month, int day) {
        int days = 0;

        for (int y = 2000; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            days += getDaysInMonth(year, m);
        }

        days += (day - 1);

        return days;
    }

    private static boolean isValid(int year, int month, int day) {
        if (year < 2000 || year > 2010) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > getDaysInMonth(year, month)) {
            return false;
        }

        return true;
    }

    private static int getDaysInMonth(int year, int month) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return DAYS_IN_MONTH[month];
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }

}
