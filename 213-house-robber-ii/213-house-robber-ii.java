class Solution {
    public int rob(int[] nums) {
    
        if(nums.length==1) return nums[0];
        int withoutFirst[] = new int[nums.length];
         int withoutLast[] = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) 
            withoutFirst[i] = nums[i];
        
        for(int i=0;i<nums.length;i++) 
            withoutLast[i] = nums[i];
        
       // int withoutLast[] = nums;
        withoutFirst[0] = 0;
        withoutLast[nums.length-1] = 0;
        //Return maximum of two results
        return Math.max(getRobSum(withoutFirst), getRobSum(withoutLast));
}
    public int getRobSum(int nums[])
    {
	//Edge/Base
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //Decide whether to consider i-2th element or not
        for(int i=2;i<n;i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[n-1];
    }
    
     
}