class Solution {
    /*public int search(int[] nums, int target) {
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
    }*/
    
    /*public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int l=0, r=nums.length-1, m=0;
       // find out the index of the smallest element.
        while(l<r){
            m = (l+r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }
        
       // since we now know the start, find out if the target is to left or right of start in the array.
        System.out.println(l);
        int s = l;
        l = 0; r = nums.length-1;
        if(target >= nums[s] && target <= nums[r]){
            l = s;
        }else{
            r = s;
        }
        // the regular search.
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target) return m;
            else if(nums[m] > target) r = m-1;
            else l=m+1;
        }
        
        return -1;
    }*/
    /*public int search(int[] nums, int target){
        if(nums==null || nums.length==0)
            return -1;
        
        int left=0,right=nums.length-1;
        
        while(left<right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else
                right=mid;
        }
        
        int start=left;
        left=0;right=nums.length-1;
        
        if(target>=nums[start] && target<=nums[right]){
            left=start;
        }
        else{
            right=start;
        }
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        
        return -1;
        
    }*/
    public int search(int[] nums, int target){
        int low=0,high=nums.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
                return mid;
            
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(nums[mid]<=target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
    
}