class Solution {
    public int minFallingPathSum(int[][] matrix) {
       if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        
        // Iterate from the second-to-last row to the top row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                // Get the minimum of the three possible cells in the row below
                int minBelow = matrix[i + 1][j];
                if (j > 0) minBelow = Math.min(minBelow, matrix[i + 1][j - 1]);
                if (j < n - 1) minBelow = Math.min(minBelow, matrix[i + 1][j + 1]);
                
                // Update the current cell with the minimum path sum
                matrix[i][j] += minBelow;
            }
        }
        
        // The answer is the minimum value in the top row
        int result = matrix[0][0];
        for (int j = 1; j < n; j++) {
            result = Math.min(result, matrix[0][j]);
        }
        
        return result; 
    }
}