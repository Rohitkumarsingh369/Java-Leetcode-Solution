class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int i = row - 1;
        int j = 0;

        while (i >= 0 && j < col) {
            int num = matrix[i][j];
            if (num > target) {
                i--;
            } else if (num < target) {
                j++;
            } else if (num == target) {
                return true;
            }
        }

        return false;
    }
}