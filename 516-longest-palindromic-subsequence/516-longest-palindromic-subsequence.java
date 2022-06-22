class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        
        int dp[][]=new int[1005][1005];
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap==0)
                    dp[i][j]=1;
                else if(gap==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j)?2:1;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}