import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1040 {

    // long + Mod/Div Operations
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        int carry = 0;
        int count = 0;

        while (num1 > 0 || num2 > 0) {
            long digit1 = num1 % 10;
            long digit2 = num2 % 10;

            if (digit1 + digit2 + carry >= 10) {
                carry = 1;
                count++;
            } else {
                carry = 0;
            }

            num1 = num1 / 10;
            num2 = num2 / 10;
        }

        System.out.println(count == 0 ? "No carry operation." : count + " carry operation" + (count > 1 ? "s." : "."));
    }

//    // String + Reverse Indexing
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        String num1 = st.nextToken();
//        String num2 = st.nextToken();
//
//        int index1 = num1.length() - 1;
//        int index2 = num2.length() - 1;
//        int carry = 0;
//        int count = 0;
//
//        while (index1 >= 0 || index2 >= 0) {
//            int digit1 = (index1 >= 0) ? num1.charAt(index1--) - '0' : 0;
//            int digit2 = (index2 >= 0) ? num2.charAt(index2--) - '0' : 0;
//
//            if (digit1 + digit2 + carry >= 10) {
//                carry = 1;
//                count++;
//            } else {
//                carry = 0;
//            }
//        }
//
//        System.out.println(count == 0 ? "No carry operation." : count + " carry operation" + (count > 1 ? "s." : "."));
//    }

}
