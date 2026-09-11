import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA26390 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 정점의 수
            int[] degrees = new int[N + 1]; // 정점의 번호는 1-based index
            int count = 0;

            for (int i = 1; i < N; i++) { // 간선의 수 = N - 1
                st = new StringTokenizer(br.readLine(), " ");

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

//                degrees[u]++;
//                degrees[v]++;

                if (degrees[u] >= 2) {
                    count++;
                } else {
                    degrees[u]++;
                }

                if (degrees[v] >= 2) {
                    count++;
                } else {
                    degrees[v]++;
                }
            }


//            for (int degree : degrees) {
//                if (degree > 2) {
//                    count += degree - 2;
//                }
//            }

            sb.append(count).append('\n');
        }

        System.out.println(sb.toString());
    }

}
