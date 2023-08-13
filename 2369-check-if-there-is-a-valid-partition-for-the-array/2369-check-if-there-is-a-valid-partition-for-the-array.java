class Solution {
Boolean[] dp;
public boolean validPartition(int[] nums) {
int n = nums.length;
dp = new Boolean[n];

    return solve(0, nums, n);
}

public boolean solve(int i, int[] nums, int n) {
    //base case
    if(i == n) return true;

    if(dp[i] != null) return dp[i];

    boolean res1= false;
    boolean res2= false;

    if(i < n-1 && nums[i]== nums[i+1]) res1 = solve(i+2, nums, n);
    if(i < n-2) {
        if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) ||
        (nums[i] + 1 == nums[i+1] && nums[i+1] == nums[i+2]-1)) {
            res2 = solve(i+3, nums, n);
        }
    }

    return dp[i] =(res1 || res2);

}
}