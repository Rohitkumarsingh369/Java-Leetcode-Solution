//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{    
    public final int mod = 1000000007;
    public int NthTerm(int n)
    {
        // code here
        if(n == 1) return 2;
        long N = 2;
        for(int i=2; i<=n; i++){
            N = ((N%mod)*(i%mod)+1)%mod;
        }
        return (int)N;
    }
}