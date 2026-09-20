import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JUNGOL1037 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        int[] rowSum = new int[n];
        int[] columnSum = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                rowSum[i] += matrix[i][j];
                columnSum[j] += matrix[i][j];
            }
        }

        int oddRowCount = 0;
        int oddColumnCount = 0;
        int oddRowIndex = -1;
        int oddColumnIndex = -1;

        for (int i = 0; i < n; i++) {
            if (rowSum[i] % 2 != 0) {
                oddRowCount++;
                oddRowIndex = i; // 0-based
            }

            if (columnSum[i] % 2 != 0) {
                oddColumnCount++;
                oddColumnIndex = i; // 0-based
            }
        }

        if (oddRowCount == 0 && oddColumnCount == 0) {
            System.out.println("OK");
//            bw.write("OK");
        } else if (oddRowCount == 1 && oddColumnCount == 1) {
            System.out.println("Change bit (" + (oddRowIndex + 1) + "," + (oddColumnIndex + 1) + ")");
//            bw.write("Change bit (" + (oddRowIndex + 1) + "," + (oddColumnIndex + 1) + ")");
        } else {
            System.out.println("Corrupt");
//            bw.write("Corrupt");
        }

//        bw.flush();
//        bw.close();
    }

}
