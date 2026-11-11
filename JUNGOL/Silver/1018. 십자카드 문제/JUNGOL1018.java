import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1018 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int target = getClockNum(nums);
        int count = 0;

        int[] candidates = new int[4];
        for (int a = 1; a <= 9; a++) {
            candidates[0] = a;
            for (int b = a; b <= 9; b++) {
                candidates[1] = b;
                for (int c = a; c <= 9; c++) {
                    candidates[2] = c;
                    for (int d = a; d <= 9; d++) {
                        candidates[3] = d;
                        int currentValue = makeNum(candidates);

                        if (getClockNum(candidates) == currentValue) {
                            count++;

                            if (currentValue == target) {
                                System.out.println(count);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }

    private static int makeNum(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result * 10 + num;
        }

        return result;
    }

    private static int getClockNum(int[] nums) {
        int len = nums.length;
        int minValue = Integer.MAX_VALUE;

        for (int start = 0; start < len; start++) {
            int currentValue = 0;

            for (int i = 0; i < len; i++) {
                currentValue = currentValue * 10 + nums[(start + i) % len];
            }

            minValue = Math.min(minValue, currentValue);
        }

        return minValue;
    }

}
