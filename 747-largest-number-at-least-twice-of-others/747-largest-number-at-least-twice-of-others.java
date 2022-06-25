class Solution {
    public int dominantIndex(int[] nums) {
        
        int max=nums[0],maxindex=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxindex=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i!=maxindex && (nums[i]*2)>max){
                return -1;
            }
        }
        
        return maxindex;
    }
}