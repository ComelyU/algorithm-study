import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1438 {

    public static void main(String[] args) throws Exception {
        final int PAPER_SIZE = 100;
        final int COLOR_PAPER_SIZE = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] paper = new boolean[PAPER_SIZE][PAPER_SIZE];
        int colorPaper = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < colorPaper; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int startX = x; startX < x + COLOR_PAPER_SIZE; startX++) {
                for (int startY = y; startY < y + COLOR_PAPER_SIZE; startY++) {
                    if (!paper[startX][startY]) {
                        paper[startX][startY] = true;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

}
