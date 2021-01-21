class Solution {
    public boolean wordBreak(String word, List<String> dictionary) {
        int dp[]=new int[word.length()];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<=i;j++) {
                String str=word.substring(j,i+1);
                if(dictionary.contains(str)) {
                    if(j>0)
                    {
                        dp[i]+=dp[j-1];
                        
                    }
                    else {
                        dp[i]+=1;
                        
                    }
                }
            }
        }
        
        return dp[word.length()-1]>0;
    }
}
