class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countSmaller(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int countSmaller(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
