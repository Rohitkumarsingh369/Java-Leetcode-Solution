class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasremaining=0;
        int total=0;
        int start=0;
        
        for(int i=0;i<gas.length;i++){
            int remaining=gas[i]-cost[i];
            if(gasremaining>=0){
                gasremaining+=remaining;
            }
            else{
                gasremaining=remaining;
                start=i;
            }
            
            total+=remaining;
        }
        
        return total>=0?start:-1;
        
    }
}