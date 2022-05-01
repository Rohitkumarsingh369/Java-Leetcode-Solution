class Solution {
   /* public int countSubstrings(String s) {
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
    }*/
    
     public int countSubstrings(String s) {
         int length=s.length();
         int dp[][]=new int[length][length];
         
         int count=0;
         
         for(int size=0;size<length;size++){
             for(int left=0,right=size;right<length;left++,right++){
                 if(size==0){
                     dp[left][right]=1;
                 }
                 else if(size==1){
                     if(s.charAt(left)==s.charAt(right))
                         dp[left][right]=1;
                     else
                         dp[left][right]=0;
                 }
                 else{
                     if(s.charAt(left)==s.charAt(right) && dp[left+1][right-1]==1)
                         dp[left][right]=1;
                     else
                         dp[left][right]=0;
                 }
                 
                 
                 if(dp[left][right]==1)
                     count++;
                     
             }
         }
         return count;
     }
}