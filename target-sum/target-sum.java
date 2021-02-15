class Solution {
   
     public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S);
    }
    private int dfs(int[] nums, int i, int S) {
        if (i == nums.length) {
            if (S == 0) 
                return 1;
            return 0;
        }
        return dfs(nums, i+1, S-nums[i]) + dfs(nums, i+1, S+nums[i]);
    }
}