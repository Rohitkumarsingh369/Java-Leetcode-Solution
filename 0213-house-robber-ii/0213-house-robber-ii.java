class Solution {
    // Helper function to calculate the maximum amount of money that can be robbed
    // in a linear arrangement of houses
    static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0; // Max money robbed till the previous house
        int prev2 = 0; // Max money robbed till the house before the previous house

        for (int i = start; i <= end; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;  // Update prev2 for the next iteration
            prev1 = current; // Update prev1 for the next iteration
        }

        return prev1;
    }

    // Main function to calculate the maximum money that can be robbed considering the circular arrangement
    static int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // Edge case: Only one house

        // Case 1: Exclude the first house
        int max1 = robLinear(nums, 1, nums.length - 1);

        // Case 2: Exclude the last house
        int max2 = robLinear(nums, 0, nums.length - 2);

        // Return the maximum of the two cases
        return Math.max(max1, max2);
    }
}