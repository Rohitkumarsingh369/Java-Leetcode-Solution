class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minB = -1; // Keep track of minK index
        int maxB = -1; // Keep track of maxK index
        int badB = -1; // Keep track of bad boundary index, any index which makes subarray not fixed-bound
        long count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) { // bad boundary index
                badB = i;
            }
            if(nums[i] == minK) {
                minB = i;
            }
            if(nums[i] == maxK) {
                maxB = i;
            }
            count += Math.max(0, Math.min(minB, maxB) - badB);
        }

        return count;
    }
}