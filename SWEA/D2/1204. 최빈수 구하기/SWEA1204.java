import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1204 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int testCaseNum = Integer.parseInt(br.readLine());
            int[] countScoreArr = new int[101]; // 점수별 빈도 배열
            int studentNum = 1000; // 학생 수

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < studentNum; i++) { // 점수별 빈도 체크
                countScoreArr[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0, idx = 0;
            for(int i = 0; i < countScoreArr.length; i++) { // 최빈값 찾기
                if(countScoreArr[i] >= max) { // 같은 빈도면 높은 점수로
                    max = countScoreArr[i];
                    idx = i;
                }
            }

            sb.append("#").append(testCaseNum).append(" ").append(idx).append("\n");
        }

        System.out.println(sb.toString());
    }

}
