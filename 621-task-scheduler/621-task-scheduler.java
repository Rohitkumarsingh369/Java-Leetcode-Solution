class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        
        for(char task:tasks){
            count[task-'A']++;
        }
        
        Arrays.sort(count);
        
        int chunk=count[25]-1;
        int idlespot=chunk*n;
        for(int i=24;i>=0;i--){
            idlespot-=Math.min(count[i],chunk);
        }
        return idlespot<0?tasks.length:idlespot+tasks.length;
    }
}