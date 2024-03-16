class Solution {
    public int maxSubArray(int[] nums) {
       
        int maxSoFar=Integer.MIN_VALUE;
        int maxEndingHere=0;
        int start=0,end=0,tempStart=0;
        for(int i=0;i<nums.length;i++){
            maxEndingHere+=nums[i];
            
            if(maxSoFar<maxEndingHere){
                maxSoFar=maxEndingHere;
                start=tempStart;
                end=i;
            }
            
            if(maxEndingHere<0){
                maxEndingHere=0;
                tempStart=i+1;
            }
        }
        return maxSoFar;
    }
}

/*
public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}*/