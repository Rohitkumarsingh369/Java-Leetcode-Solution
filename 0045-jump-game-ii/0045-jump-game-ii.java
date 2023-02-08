class Solution {
   
    public int jump(int[] nums) {
        
        int jump=0,curend=0,maxlocation=0;
        
        for(int i=0;i<nums.length-1;i++){
            
            maxlocation=Math.max(maxlocation,i+nums[i]);
            
            if(i==curend){
                jump++;
                curend=maxlocation;
            }
        }
        
        return jump;
 }
}

/*The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:*/