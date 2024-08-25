class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        int prev2=0,prev=nums[0];
        
        for(int i=1;i<len;i++){
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