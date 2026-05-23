import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA26792 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // A + B = X, A - B = Y 이므로 연립방정식을 활용하여
            // 두 식을 더해서 2A = X + Y, A = (X + Y) / 2
            // 두 식을 빼서 2B = X - Y, B = (X - Y) / 2
            // 위 두가지를 통해 값을 구하거나 하나를 통해 값을 구한 뒤 다른 식에 대입
            int A = (X + Y) / 2;
//            int B = (X - Y) / 2;
            int B = X - A;

            sb.append(A).append(' ').append(B).append('\n');
        }
        System.out.println(sb.toString());
    }

}
