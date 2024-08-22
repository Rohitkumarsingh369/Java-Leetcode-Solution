class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int length=nums.length;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<length;i++){
            max=Math.max(max,nums[i]);
        }
        
        int low=1,high=max;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(sumOfDivisor(nums,mid)<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    
    private int sumOfDivisor(int arr[],int day){
        int length=arr.length;
        int sum=0;
        
        for(int i=0;i<length;i++){
            sum+=Math.ceil((double)arr[i]/(double)day);
        }
        return sum;
    }
}