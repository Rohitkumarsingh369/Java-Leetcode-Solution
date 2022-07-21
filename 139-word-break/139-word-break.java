class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean []dp=new boolean[n+1];
        
        dp[0]=true;
        
        for(int i=1;i<=n;i++){
            boolean flag=false;
            for(int j=0;j<i;j++){
                if(dp[j]){
                    String subs=s.substring(j,i);
                    
                    if(wordDict.contains(subs)){
                        flag=true;
                        break;
                    }
                }
            }
            
            dp[i]=flag;
        }
        
        return dp[n];
    }
}