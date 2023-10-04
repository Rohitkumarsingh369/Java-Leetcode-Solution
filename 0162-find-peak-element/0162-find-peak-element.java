class Solution {
    /*public int findPeakElement(int[] num) {
     // First or last element is peak element
            int n=arr.length;
        if (n == 1)
          return 0;
        if (arr[0] >= arr[1])
            return 0;
        if (arr[n - 1] >= arr[n - 2])
            return n - 1;

        // Check for every other element
        for(int i = 1; i < n - 1; i++)
        {

            // Check if the neighbors are smaller
            if (arr[i] >= arr[i - 1] &&
                arr[i] >= arr[i + 1])
                return i;
        }
        return 0;
    }*/
    
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[len-1]>nums[len-2])
            return len-1;
        
        int low=1,high=len-2;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            
            else if(nums[mid]>nums[mid-1])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
        
    }
}