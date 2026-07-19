public class LTC67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while(aIndex >= 0 || bIndex >= 0 || carry != 0) {
            int sum = carry;

            if(aIndex >= 0) {
                sum += a.charAt(aIndex) - '0';
                aIndex--;
            }

            if(bIndex >= 0) {
                sum += b.charAt(bIndex) - '0';
                bIndex--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

}
