class Solution {
    public boolean canJump(int[] nums) {
        int result=minjump(nums,nums.length);
        if(result!=-1)
            return true;
        
    return false;
    }
    public int minjump(int nums[],int n){
        if(n<=1)
            return 0;
        
        if(nums[0]==0)
            return -1;
        
            int maxReach=nums[0],step=nums[0],jump=1;
        
            for(int i=1;i<n;i++){
                if(i==n-1)
                    return jump;
                
                maxReach=Math.max(maxReach,i+nums[i]);
                
                step--;
                
                if(step==0){
                    jump++;
                    
                    if(i>=maxReach)
                        return -1;
                    
                    step=maxReach-i;
                }
            }
        return -1;
    }
}
