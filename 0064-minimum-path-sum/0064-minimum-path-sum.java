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
        
        int row=grid.length;
        int col=grid[0].length;
        
        int []dp=new int[col];
            dp[0]=grid[0][0];
        for(int i=1;i<col;i++){
            dp[i]=dp[i-1]+grid[0][i];
        }
        
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0)
                    dp[j]+=grid[i][j];
                else if(j>0)
                    dp[j]=grid[i][j]+Math.min(dp[j],dp[j-1]);
            }
        }
        return dp[col-1];
    }
}