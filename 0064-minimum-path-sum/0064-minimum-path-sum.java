class Solution {
    public int minPathSum(int[][] grid) {
        /*int row=grid.length;
        int col=grid[0].length;
        
        for(int i=1;i<col;i++){
            grid[0][i]+=grid[0][i-1];
        }
        
        for(int i=1;i<row;i++){   
            grid[i][0]+=grid[i-1][0];
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j]+=Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        
        return grid[row-1][col-1];*/
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Initialize a 1D dp array for storing the minimum path sums for each column
        int[] dp = new int[cols];
        
        // Fill the dp array for the first row
        dp[0] = grid[0][0];
        for (int j = 1; j < cols; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Iterate over the grid starting from the second row
        for (int i = 1; i < rows; i++) {
            // Update the first element in the current row
            dp[0] += grid[i][0];
            
            // Update the rest of the dp array for the current row
            for (int j = 1; j < cols; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        // The last element in dp contains the minimum path sum to the bottom-right corner
        return dp[cols - 1];
    }
}