class Solution {
    public boolean search(int[] nums, int target) {
        int length=nums.length;
        int low=0,high=length-1;
        int mid=0;
        
        while(low<=high){
            mid=low+(high-low)/2;
            
            if(nums[mid]==target){
                return true;
            }
            
            //trim the array to remove the duplicate
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            
            //if left is sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            //if right is sorted
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}