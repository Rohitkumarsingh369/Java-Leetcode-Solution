class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=nums.length;
        int start=0,end=0,sum=0;
        int result=Integer.MAX_VALUE;
        while(start<=end){
            if(sum>=target){
                result=Math.min(result,end-start);
                sum-=nums[start];
                start++;
            }
            else if(end<length){
                sum+=nums[end];
                end++;
            }
            else if(end==length){
                start++;
            }
        }
       
        return result=result==Integer.MAX_VALUE?0:result;
    }
}