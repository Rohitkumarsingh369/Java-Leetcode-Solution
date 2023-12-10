class Solution {
    /*public int minDistance(String word1, String word2) {
         int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        // Base cases
        // Initializing First row
        for(int i=0; i <= l2; i++)
            dp[0][i] = i;        
        // Initializing First col
        for(int i=0; i <= l1; i++)
            dp[i][0] = i;
        
        for(int i=1; i <= l1; i++){
            for(int j=1; j <= l2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], // replace
                                            Math.min(dp[i-1][j], // delete
                                                     dp[i][j-1]) // insert
                                           ); 
            }
        }
        
        return dp[l1][l2];
    }*/
    public int minDistance(String a,String b){
        int n=a.length();
        int m=b.length();

        int dp[]=new int[m+1];
        
        for(int i=0;i<=m;i++){
            dp[i]=i;
        }

        for(int i=1;i<n+1;i++){
            int prev=dp[0];
            dp[0]=i;
            for(int j=1;j<m+1;j++){
                int temp=dp[j];
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[j]=prev;
                }
                else{
                    dp[j]=1+Math.min(prev,Math.min(dp[j],dp[j-1]));
                }
                prev=temp;
            }
        }
        return dp[m];
    }
}