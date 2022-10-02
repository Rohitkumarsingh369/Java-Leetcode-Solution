class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] arr1: dp) {
             Arrays.fill(arr1, -1);
        }
        return getCount(n, k, target, dp);
    }
    
    final int MOD = 1000000007;
    
    private int getCount(int n, int k, int target, int[][]dp) {
        if(n == 0 && target == 0) {
            return 1;
        }
        
        if(n <= 0 || target < 0) {
            return 0;
        }
        
        if(dp[n][target] != -1) {
            return dp[n][target];
        }
        long result = 0;
        for(int i = 1; i <= k; i ++) {
            if(target >= i) {
                result = (result + getCount(n -1, k, target - i, dp)) % MOD ;
            } 
        }
        dp[n][target] = (int)result;
        return dp[n][target];
    }
}