class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        /*int result=0;
        for(int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;*/
        
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            
            int mid = (low+high)/2;
            if(nums[mid] == nums[mid^1]){
                low = mid+1;
            }
            else{
                high = mid;
            }
            
            
        }
        return nums[low];
    }
}