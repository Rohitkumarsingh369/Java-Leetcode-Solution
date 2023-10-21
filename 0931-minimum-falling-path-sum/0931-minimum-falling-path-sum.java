/*class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // If the matrix has only one row, return the minimum element in that row
        if (n == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix[0].length; i++) {
                min = Math.min(min, matrix[0][i]);
            }
            return min;
        }

        // Update the matrix to store the minimum sum falling path at each cell
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int prevRow = row - 1;
                int minSum = matrix[prevRow][col];

                if (col > 0) {
                    minSum = Math.min(minSum, matrix[prevRow][col - 1]);
                }
                if (col < n - 1) {
                    minSum = Math.min(minSum, matrix[prevRow][col + 1]);
                }

                matrix[row][col] += minSum;
            }
        }

        // Find the minimum sum in the last row
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minFallingPathSum = Math.min(minFallingPathSum, matrix[n - 1][i]);
        }

        return minFallingPathSum;
    }
}*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // If the matrix has only one row, return the minimum element in that row
        if (n == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix[0].length; i++) {
                min = Math.min(min, matrix[0][i]);
            }
            return min;
        }

        int[] dp = new int[n];
        System.arraycopy(matrix[0], 0, dp, 0, n);

        for (int row = 1; row < n; row++) {
            int[] newDp = new int[n];
            for (int col = 0; col < n; col++) {
                newDp[col] = matrix[row][col] + dp[col];
                if (col > 0) {
                    newDp[col] = Math.min(newDp[col], matrix[row][col] + dp[col - 1]);
                }
                if (col < n - 1) {
                    newDp[col] = Math.min(newDp[col], matrix[row][col] + dp[col + 1]);
                }
            }
            dp = newDp;
        }

        int minFallingPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minFallingPathSum = Math.min(minFallingPathSum, dp[i]);
        }

        return minFallingPathSum;
    }
}

