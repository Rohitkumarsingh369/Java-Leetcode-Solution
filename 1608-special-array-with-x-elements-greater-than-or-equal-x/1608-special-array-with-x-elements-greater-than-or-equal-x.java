class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] >= nums.length) return nums.length;
        for (int i = 1; i <= nums.length - 1; i++) {
            int count = nums.length - i;
            if(nums[i] >= count && nums[i - 1] < count) {
                return count;
            }
        }
        return -1;
    }
}