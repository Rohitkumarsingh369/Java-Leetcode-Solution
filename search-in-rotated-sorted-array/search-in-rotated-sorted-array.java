class Solution {
    public int search(int[] nums, int target) {
        int result=bsearch(nums,0,nums.length-1,target);
        return result;
    }
    static int bsearch(int nums[],int low,int high,int target){
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        
        if(nums[mid]==target)
            return mid;
        
        if(nums[low]<=nums[mid]){
            
            if(target>=nums[low]&&target<=nums[mid])
                return bsearch(nums,low,mid-1,target);
            
          return bsearch(nums,mid+1,high,target);  
        }
        if(target>=nums[mid]&&target<=nums[high])
                return bsearch(nums,mid+1,high,target);
            
          return bsearch(nums,low,mid-1,target);  
        
    }
}