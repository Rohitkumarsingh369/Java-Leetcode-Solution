class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startr = Math.min(startPos[0],homePos[0]);
        int endr = Math.max(startPos[0],homePos[0]);
        
        int startc = Math.min(startPos[1],homePos[1]);
        int endc = Math.max(startPos[1],homePos[1]);
        
        int sum = 0;
        for(int i = startr;i<=endr;i++){
            sum += rowCosts[i];
        }
        
        for(int i = startc;i<=endc;i++){
            sum += colCosts[i];
        }
        
        sum -= rowCosts[startPos[0]] + colCosts[startPos[1]];
        return sum; 
    }
}