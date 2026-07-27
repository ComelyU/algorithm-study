public class LTC48 {

    // Layer-by-Layer Rotation
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Set the boundaries for layers
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        // Loop while moving into the inner layers
        while(left < right) {
            // Iterate through the number of elements to rotate in the current layer
            int layerSize = right - left;
            for(int i = 0; i < layerSize; i++) {
                // Save the top-left element into a temp
                int temp = matrix[top][left + i];

                // Move bottom-left element to top-left
                matrix[top][left + i] = matrix[bottom - i][left];

                // Move bottom-right element to bottom-left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // Move top-right element to bottom-right
                matrix[bottom][right - i] = matrix[top + i][right];

                // Move the temp(original top-left) to top-right
                matrix[top + i][right] = temp;
            }

            // Shrink the boundaries by one step inward for the next layer
            top++;
            bottom--;
            left++;
            right--;
        }
    }


//    // Transpose and Reverse
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        // Transpose
//        for(int i = 0; i < n; i++) {
//            // j starts index i: Prevent swap of already swapped elements
//            for(int j = i; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//
//        // Reverse: Using Two Pointer
//        for(int i = 0; i < n; i++) {
//            int start = 0;
//            int end = n - 1;
//
//            while(start < end) {
//                int temp = matrix[i][start];
//                matrix[i][start] = matrix[i][end];
//                matrix[i][end] = temp;
//
//                start++;
//                end--;
//            }
//        }
//    }

}
