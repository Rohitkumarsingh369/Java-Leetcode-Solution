class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n < 3) return n;
        int[][] dp = new int[n+1][1000+10]; 
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int diff = nums[i]-nums[j];
                dp[i][diff+500] = Math.max(dp[i][diff+500] ,dp[j][diff+500]+1);
                max=Math.max(max,dp[i][diff+500]);
            }
        }
        return max+1;
    }
}