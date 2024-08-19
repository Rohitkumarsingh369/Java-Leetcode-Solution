class Solution {
    public int maxSubArray(int[] nums) {
       
        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=0, end=0, tempStart=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(sum>max){
                max=sum;
            }
            
            if(sum<0){
                sum=0;
            }
        }
        return max;
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