class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char X[]=text1.toCharArray();
        char Y[]=text2.toCharArray();
        
        //length of the char array
        int m=X.length;
        int n=Y.length;
        
        int dp[][]=new int [m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                
                if(i==0 || j==0)
                    dp[i][j]=0;
                
                else if(X[i-1]==Y[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}