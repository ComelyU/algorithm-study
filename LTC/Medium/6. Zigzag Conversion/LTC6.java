public class LTC6 {

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int rowIndex = 0;
        int lastRowIndex = numRows - 1;
        boolean moveDown = false;
        for (char letter : s.toCharArray()) {
            rows[rowIndex].append(letter);

            if (rowIndex == 0 || rowIndex == lastRowIndex) {
                moveDown = !moveDown;
            }

            rowIndex += moveDown ? 1 : -1;
        }

        StringBuilder convertedS = new StringBuilder();
        for (StringBuilder row : rows) {
            convertedS.append(row);
        }

        return convertedS.toString();
    }

}
