class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        
        return helper(nums,target,0,nums.length-1);
    }
    
    public int helper(int []nums,int target,int low,int high){
        if(low>high){
            return -1;
        }
        
        int mid=low+(high-low)/2;
        
        if(nums[mid]==target){
            return mid;
        }
        
        int left=helper(nums,target,low,mid-1);
        int right=helper(nums,target,mid+1,high);
        
        if(left!=-1 || right!=-1){
            return left!=-1?left:right;
        }
        
        return -1;
    }
}