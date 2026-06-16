import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA26389 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            boolean east = false, west = false, south = false, north = false;
            char[] direction = br.readLine().toCharArray();

            for(char c : direction) {
                if(c == 'E') {
                    east = true;
                } else if(c == 'W') {
                    west = true;
                } else if(c == 'S') {
                    south = true;
                } else if(c == 'N') {
                    north = true;
                }
            }

            // 한 번도 해당 방향과 그 반대 방향으로 가지 않거나, 양쪽 다 한 번 이상은 가야함.
            // 즉, 동서 / 남북 은 각각 같은 값이어야 함.
            boolean isEastWestValid = (east == west);
            boolean isSouthNorthValid = (south == north);

            if(isEastWestValid && isSouthNorthValid) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.println(sb.toString());
    }

}
