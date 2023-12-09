class Solution {
   /* public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        
        int dp[][]=new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else 
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }*/
    
    public int longestCommonSubsequence(String text1, String text2){
       int len1 = text1.length();
    int len2 = text2.length();

    int[] dp = new int[len2 + 1];

    for (int i = 1; i <= len1; i++) {
        int prev = 0; // To store the value of dp[i-1][j-1] before it gets updated

        for (int j = 1; j <= len2; j++) {
            int temp = dp[j]; // To store the value of dp[i-1][j] before it gets updated

            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                dp[j] = 1 + prev; // dp[i][j] = 1 + dp[i-1][j-1]
            } else {
                dp[j] = Math.max(dp[j], dp[j - 1]); // dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            }

            prev = temp;
        }
    }

    return dp[len2];
        }
    
}