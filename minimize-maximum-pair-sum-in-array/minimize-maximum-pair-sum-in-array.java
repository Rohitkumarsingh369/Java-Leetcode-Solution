class Solution {
    public int minPairSum(int[] nums) {
        
        int max_sum=Integer.MIN_VALUE;
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        
        while(left<right){
            int sum=nums[left]+nums[right];
            max_sum=Math.max(sum,max_sum);
            left++;
            right--;
        }
        return max_sum;
    }
}