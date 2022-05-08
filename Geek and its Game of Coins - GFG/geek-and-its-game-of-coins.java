// { Driver Code Starts
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
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int findWinner(int n,int x,int y)
    {
        // Code here
        // To store results
        boolean[] dp = new boolean[n + 1];
      
        Arrays.fill(dp, false);
     
        // Initial values
        dp[0] = false;
        dp[1] = true;
      
        // Computing other values.
        for (int i = 2; i <= n; i++) {
      
            // If A losses any of i-1 or i-x
            // or i-y game then he will
            // definitely win game i
            if (i - 1 >= 0 && dp[i - 1] == false)
                dp[i] = true;
            else if (i - x >= 0 && dp[i - x] == false)
                dp[i] = true;
            else if (i - y >= 0 && dp[i - y] == false)
                dp[i] = true;
      
            // Else A loses game.
            else
                dp[i] = false;
        }
      
        // If dp[n] is true then A will
        // game otherwise  he losses
        
        if(dp[n]==true)
            return 1;
        return 0;
    }
}