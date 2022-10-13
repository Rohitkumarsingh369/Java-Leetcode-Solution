class Solution {
    public long subArrayRanges(int[] nums) {
        long result=0;
        
        for(int i=0;i<nums.length;i++){
            int max=nums[i],min=nums[i];
            
            for(int j=i;j<nums.length;j++){
                max=Math.max(max,nums[j]);
                min=Math.min(nums[j],min);
                
                result+=max-min;
            }
        }
        return result;
    }
}