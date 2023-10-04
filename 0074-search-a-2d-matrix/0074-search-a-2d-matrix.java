class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }
 
        int tempRow = row - 1;
        int tempCol= 0;

        while (tempRow >= 0 && tempCol < col) {
            int num = matrix[tempRow][tempCol];
            if (num > target) {
                tempRow--;
            } else if (num < target) {
                tempCol++;
            } else if (num == target) {
                return true;
            }
        }

        return false;
    }
}