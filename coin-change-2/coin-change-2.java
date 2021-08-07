class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[]=new int[amount+1];
        
        dp[0]=1;
        
        if(amount==0)
            return 1;
        
        if(amount<0)
            return 0;
        
        if(amount>=1 && coins.length<=0)
            return 0;
        
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}