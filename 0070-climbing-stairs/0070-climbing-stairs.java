class Solution {
    public int climbStairs(int n) {
       if (n <= 1) return 1; // Base cases
        
        int prev1 = 1; // Number of ways to reach step 0
        int prev2 = 1; // Number of ways to reach step 1
        
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2; // Number of ways to reach current step
            prev1 = prev2; // Update prev1 to the last step
            prev2 = curr; // Update prev2 to the current step
        }
        
        return prev2; // Number of ways to reach the top step
    }
}