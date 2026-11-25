public class LTC43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int num1Length = num1.length();
        int num2Length = num2.length();

        // maximum length of the product of two number is (num1Length + num2Length)
        int[] pos = new int[num1Length + num2Length];

        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int pos1 = i + j; // Index for the carry
                int pos2 = i + j + 1; // Index for the current digit

                int sum = mul + pos[pos2]; // Add the current product to the existing value at pos2

                pos[pos1] += sum / 10; // Add the carry to the previous position
                pos[pos2] = sum % 10; // Store the single digit at the current position
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : pos) {
            if (!sb.isEmpty() || digit != 0) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }

}
