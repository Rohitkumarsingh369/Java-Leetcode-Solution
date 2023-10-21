class Solution {
    public int uniquePaths(int m, int n) {
        /*int dp[][]=new int[m][n];
        
        for(int i=0;i<n;i++)//fill last row with 1
        {
            dp[m-1][i]=1;
        }
        for(int i=0;i<m;i++)//fill last column with 1
        {
            dp[i][n-1]=1;
        }
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
       return  dp[0][0];*/
        
        
        int dp[]=new int[n];
        
        for(int i=0;i<n ;i++){
            dp[i]=1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]+=dp[j-1];
            }
        }
        
        return dp[n-1];
    }
}