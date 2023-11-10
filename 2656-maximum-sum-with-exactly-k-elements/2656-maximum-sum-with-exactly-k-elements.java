class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            max=Math.max(max, nums[i]);
        int x = (max+ max+k-1)* k/2;
        return x;
    }
}