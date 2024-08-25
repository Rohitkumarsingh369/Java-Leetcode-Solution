class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        
        if(len==1){
            return nums[0];
        }
       int result1=solve(nums,0,len-2); //remove the last element
       int result2=solve(nums,1,len-1); //remove the first element
        
        return Math.max(result1,result2);
    }
    
    private int solve(int nums[],int start,int end){
        int prev2=0,prev=nums[start];
        
        for(int i=start+1;i<=end;i++){
            int pick=nums[i];
            
            if(i>1){
                pick+=prev2;
            }
            
            int notPick=prev;
            
            int current=Math.max(pick,notPick);
            prev2=prev;
            prev=current;
        }
        
        return prev;
    }
}