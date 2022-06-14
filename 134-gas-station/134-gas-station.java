class Solution {
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
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
        
    }*/
    /* int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;*/
     public int canCompleteCircuit(int[] gas, int[] cost) {
        int remaining=0;
        int total=0;
        int start=0;
        
        for(int i=0;i<gas.length;i++){
            remaining+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(remaining<0){
            
                remaining=0;
                start=i+1;
            }
           
        }
        
        return total<0?-1:start;
        
    }
}