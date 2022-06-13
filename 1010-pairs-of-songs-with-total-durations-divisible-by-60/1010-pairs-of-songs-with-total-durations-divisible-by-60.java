class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for(int i:time) count[i%60]++;
        
        //count the time from 1-29 & 29-59
        for(int i =1;i<30;i++) res+=count[i]*count[60-i];
        
        //edge case
        //How many pair: (n-1) + (n-2)+ ... + (n-n)
        //count the time 0 
        for(int i =1;i<count[0];i++) res+=count[0]-i;
        //count the time 30 
        for(int i =1;i<count[30];i++) res+=count[30]-i;
        
        return res;
    }
}