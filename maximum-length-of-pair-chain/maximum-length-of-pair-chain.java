class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        int len=pairs.length;
        int dp[]=new int[len];
        
        Arrays.fill(dp,1);
        int max=dp[0];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        
        return max;
    }
}