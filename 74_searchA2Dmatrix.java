class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns

        // Treat the 2D matrix as a flattened 1D sorted array
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            // Find middle index in the virtual 1D array
            int mid = left + (right - left) / 2;

            // Convert 1D index back to 2D indices // 1D index → 2D (row, col)
            //divide = row, mod = column
            int midValue = matrix[mid / n][mid % n];

            // Standard binary search comparisons
            if (midValue == target) {
                return true;
            }
            else if (midValue < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}

// TC: O(log(m × n))
// Binary search over all elements.

// SC: O(1)
// No extra space used.

// 1. Consider the 2D matrix as a single sorted 1D array.
// 2. Apply binary search on indices from 0 to (m*n - 1).
// 3. Convert the mid index into row and column using:
//    row = mid / n, col = mid % n.
// 4. Compare the matrix value with the target.
// 5. Adjust search range accordingly until found or exhausted.
