class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        if(m==0)
            return 0;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        
        for(int i=0;i<n;i++)//fill first row with 1
        {
           if( obstacleGrid[0][i]!=1)
                dp[0][i]=1;
            else
                break;
        }
        for(int i=0;i<m;i++)//fill last column with 1
        {
            if( obstacleGrid[i][0]!=1)
             dp[i][0]=1;
            else
                break;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
       return  dp[m-1][n-1];
    }
}