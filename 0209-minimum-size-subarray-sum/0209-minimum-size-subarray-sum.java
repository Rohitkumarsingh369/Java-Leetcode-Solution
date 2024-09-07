class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=nums.length;
        int left=0,sum=0;
        int result=Integer.MAX_VALUE;
        
        for(int right=0;right<length;right++){
            sum+=nums[right];
            
            while(sum>=target){
                result=Math.min(result,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        
       
        return result=result==Integer.MAX_VALUE?0:result;
    }
}