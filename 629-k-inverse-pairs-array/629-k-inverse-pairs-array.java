class Solution {
    public int kInversePairs(int n, int k) {
        long mod = 1000000007L;
        
        long dp[] = new long[k+1];
        
        dp[0] = 1;
        
        for (int i=2; i<=n; i++) {
            
            long curr[] = new long[k+1];
            
            for (int j=0; j<curr.length; j++) {
                
                long currVal  = j   == 0 ? 0 : curr[j-1];  // for j=0 -> 0, else curr[j-1]
                long currDiff = j-i <  0 ? 0 : dp[j-i];
                
                curr[j] = (dp[j] + currVal - currDiff + mod) % mod;
                
            }
            
            dp = curr;
            
        }
        
        return (int) dp[k];
    }
}