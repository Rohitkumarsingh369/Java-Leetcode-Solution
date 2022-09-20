class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length,k=0 ;
        while(k<len){
            int size = len-k-1;            
            for(int i=0;i<size;++i)
                nums[i]= (nums[i]+nums[i+1])%10;
            ++k;            
        }
        return nums[0];
    }
}