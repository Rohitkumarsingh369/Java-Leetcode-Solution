class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        long dp[]=new long[n+1];
        
        dp[0]=1;
        long last[]=new long[256];
        Arrays.fill(last,-1);
        
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            dp[i]=(mod+2*dp[i-1]%mod)%mod;
            
           
            if(last[s.charAt(i-1)]!=-1)
                dp[i]=(mod+dp[i]-dp[(int)last[(int)(s.charAt(i-1))]])%mod;
            
            dp[i]%=mod;
            last[(int)s.charAt(i-1)]=(i-1);
        }
        return (int)(dp[n]-1);
    }
}