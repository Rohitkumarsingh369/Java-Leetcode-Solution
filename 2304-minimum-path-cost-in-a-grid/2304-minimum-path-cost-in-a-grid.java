class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0;k<grid[0].length;k++)
                {
                    if(i-1 == -1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = Math.min(moveCost[grid[i-1][k]][j] + grid[i-1][k] +dp[i-1][k] , dp[i][j]);
                    // System.out.println("{"+moveCost[grid[i-1][k]][j] +","+grid[i]",")
                    
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
            
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i<grid[0].length;i++)
        {
          min =  Math.min(min,dp[grid.length-1][i]+grid[grid.length-1][i]);
        }
        return min;
    }
}