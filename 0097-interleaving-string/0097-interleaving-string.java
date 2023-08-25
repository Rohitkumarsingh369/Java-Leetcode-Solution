class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length(), i, j;
        if(m+n != t) return false;
        if(m == 0) return s2.equals(s3);
        if(n == 0) return s1.equals(s3);
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // first Row
        for(i=1; i<=n; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]) 
                dp[0][i] = true;
        }
        
        // first column
        for(i=1; i<=m; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]) 
                dp[i][0] = true;
        }
        
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))){
                   dp[i][j] = true;
                }
            }
        }
        
        for(int x=0;x<=m;x++){
            for(int y=0;y<=n;y++){
                System.out.print(dp[x][y]+"\t");
            }
            System.out.println();
        }
        return dp[m][n]; 
    }
}