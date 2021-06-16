class Solution {
    
    boolean[] taken;
 
    private boolean backtrack(int[] matchsticks, int length, int index){
        if(length ==0)
            return true;
        
        for(int i=index; i>=0;i--){
            //candidate
            if(!taken[i] && matchsticks[i] <= length){
                //go forward
                taken[i] = true;
                if(backtrack(matchsticks,length -matchsticks[i],i-1))
                    return true;
                else{
                    //backtrack
                    taken[i] = false;
                }
            }
        }
        return false;
    }
    
    public boolean makesquare(int[] matchsticks) {
        this.taken = new boolean[matchsticks.length];
        
        int sum=0;
        for(int match:matchsticks)
            sum += match;
        if(sum%4 !=0)
            return false;
        
        //now - we have the side
        int sideLength = sum/4;
        Arrays.sort(matchsticks);

        //DFS for each side 
        
        for(int i=0;i<4;i++){
            if(backtrack(matchsticks,sideLength,matchsticks.length-1)==false)
                return false;
        }
        return true;
    }
}