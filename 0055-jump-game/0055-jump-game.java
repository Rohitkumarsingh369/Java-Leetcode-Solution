class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        // Traverse each index of the array
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                // If current index is beyond the farthest reachable index, return false
                return false;
            }
            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
        }

        // If the loop completes, it means we can reach the last index
        return true;
    }
}