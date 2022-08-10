class Solution {
    public int minSwaps(int[] nums) {
        int oneCount = 0, n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) k++;
        }
        for(int i = 0; i < k; i++){
            if(nums[i] == 1) oneCount++;
        }
        
        int[] arr = new int[2*n];
        for(int i = 0; i < 2*n; i++){
            arr[i] = nums[i%n];
        }
        
        int si = 0, ei = k-1, one = 0;
        int maxOne = oneCount;
        
        
        while(ei < (2*n)-1){
            if(arr[++ei] == 1){
                oneCount++;
            }
            if(arr[si++] == 1){
                oneCount--;
            }
            maxOne = Math.max(maxOne, oneCount);
        }
       
        return k-maxOne;
    }
}