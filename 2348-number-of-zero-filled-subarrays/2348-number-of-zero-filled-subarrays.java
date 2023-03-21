class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long c=0,k=0,max=0;
       // System.out.print(nums.length);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++; 
                k++;
            }
            else{
                max=max+(c*(c-1))/2;
                c=0;
            }
        }
        if(nums[nums.length-1]==0) max=max+(c*(c-1))/2;
        max+=k;
        return max;
    }
}