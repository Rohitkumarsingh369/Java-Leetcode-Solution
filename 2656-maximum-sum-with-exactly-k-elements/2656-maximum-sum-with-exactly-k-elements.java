class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int sum =0 ;
        for(int i = 0 ; i < k ; i++){
            sum += nums[nums.length-1];
            nums[nums.length-1]++;
        }
        return sum;
    }
}