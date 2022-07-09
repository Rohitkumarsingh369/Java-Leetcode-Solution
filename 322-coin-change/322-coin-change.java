class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[] = new int[amount + 1];

          Arrays.fill(dp, amount + 1);
          dp[0] = 0;

          for(int i = 1; i <= amount; i++){
              for(int coin_denomination : coins){
             //if coin value/denomination is less than or equal to amount     
                  if(coin_denomination <= i){
                  dp[i] = Math.min(dp[i], dp[i - coin_denomination]+1);
                  }
              }
          }
 
        //overflow conditon
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}