class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int dp[][] = new int[n][n];
        int count=0;
        
        for (int l=0;l<n;l++) {
            
            for (int i = 0,j=l; j < n; i++,j++) {
                if(l==0)
                    dp[i][j] = 1;
                else if(l==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else
                {
                     if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
              if(dp[i][j]==1)
                  count++;
            }
            
        }
 
        // return total palindromic substrings
        return count;
    }
}