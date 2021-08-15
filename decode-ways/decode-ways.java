class Solution {
    public int numDecodings(String str) {
        int n=str.length();
        int mod=1000000007;
        int count[]=new int[n+1];
        
        count[0]=1;
        count[1]=1;
        
        if(str.charAt(0)=='0')
        return 0;
        for(int i=2;i<=n;i++){
            count[i]=0;
            if(str.charAt(i-1)>'0')
                count[i]=count[i-1];
            
            if(str.charAt(i-2)=='1'||(str.charAt(i-2)=='2'&& str.charAt(i-1)<'7'))
                count[i]+=count[i-2];
        }
        
        return count[n];
    }
}