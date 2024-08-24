class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        
        int step1=1;
        int step2=1;
        
        for(int i=2;i<=n;i++){
            int step=step1+step2;
            step1=step2;
            step2=step;
        }
        return step2;
    }
}