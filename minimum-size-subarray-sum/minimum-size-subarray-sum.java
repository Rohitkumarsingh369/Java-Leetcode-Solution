class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        if(nums.length==0)
            return 0;
        int sum=0,res=Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<=j){
            if(sum>=s)
            {
                res=Math.min(res,j-i);
                sum-=nums[i];
                i++;
            }
            else if(j<nums.length){
                sum+=nums[j];
                j++;
            }
            else if(j==nums.length)
                i++;
        }
        if(res==Integer.MAX_VALUE)
            return 0;
        
        return res;
    }
}
