class Solution {
    public int lengthOfLIS(int[] nums) {
        /*int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
                max=Math.max(max,dp[i]);
            }
        }
        return max;*/
        
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}