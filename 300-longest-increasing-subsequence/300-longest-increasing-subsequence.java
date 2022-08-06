class Solution {
    public int lengthOfLIS(int[] nums) {
        /*int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
                max=Math.max(max,dp[i]);
            }
        }
        return max;*/
        
        int tailindex[]=new int[nums.length];
        tailindex[0]=nums[0];
        int len=1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]<tailindex[0]){
                tailindex[0]=nums[i];
            }
            else if(nums[i]>tailindex[len-1]){
                tailindex[len++]=nums[i];
            }
            else{
                tailindex[position(tailindex,-1,len-1,nums[i])]=nums[i];
            }
        }
        return len;
    }
        public int position(int tailindex[],int low,int high,int key){
            while(high-low>1){
                int mid=low+(high-low)/2;
                
                if(tailindex[mid]>=key){
                    high=mid;
                }
                else{
                    low=mid;
                }
            }
            return high;
        }
}