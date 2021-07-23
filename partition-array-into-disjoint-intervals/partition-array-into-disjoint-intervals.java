class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        
        int arr[]=new int[n];
        
        arr[0]=nums[0];
        
        for(int i=1;i<n;i++){
            arr[i]=nums[i]>arr[i-1]?nums[i]:arr[i-1];
        }
        
        arr[n-1]=nums[n-1];
        
        int res=0;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]<=arr[i+1])
                res=i+1;
            
            arr[i]=nums[i]<arr[i+1]?nums[i]:arr[i+1];
        }
        
        return res;
    }
}