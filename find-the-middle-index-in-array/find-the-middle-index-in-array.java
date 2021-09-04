class Solution {
    public int findMiddleIndex(int[] nums) {

        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        
        int prefixsum=0;
        
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            
            if(prefixsum==sum)
                return i;
             
            prefixsum+=nums[i];
        }
        return -1;
        
    }
}