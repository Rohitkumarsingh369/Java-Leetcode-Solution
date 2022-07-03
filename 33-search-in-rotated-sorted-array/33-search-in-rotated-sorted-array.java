class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        
        return helper(nums,target,0,nums.length-1);  
    }
    
    public int helper(int[] nums, int tar, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = low+(high-low)/2;
        
        if(nums[mid] == tar){
            return mid;
        }
        
        int left = helper(nums,tar,low,mid-1);
        int right = helper(nums, tar, mid+1, high);
        
        if(left != -1 || right != -1){
            return left == -1 ? right : left;
        }
        
        return -1;
    }
}