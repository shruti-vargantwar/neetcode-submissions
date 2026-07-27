/**
Goal: find target row using binary search
Once target row is identified, by target number in target row using binary search
Solve 240. Search a 2D Matrix II after this problem
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0, endRow = m - 1;

        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= matrix[midRow][0] && target <= matrix[midRow][n - 1]) {
                // found target row. Perform binary search on this row
                return searchInRow(matrix, target, midRow);
            } else if (target <= matrix[midRow][0]) {
                endRow = midRow - 1; // Go up
            } else {
                // Go down
                startRow = midRow + 1;
            }
        }

        return false;
    }

    private boolean searchInRow(int[][] matrix, int target, int row) {
        int startCol = 0, endCol = matrix[0].length - 1;

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            
            if (target == matrix[row][midCol]) {
                return true;
            } else if (target > matrix[row][midCol]) {
                startCol = midCol + 1;
            } else {
                endCol = midCol - 1;
            }
        }

        return false;
    }
}
