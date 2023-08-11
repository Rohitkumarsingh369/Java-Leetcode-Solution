//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long coinChange(int ind, int Amount, int [] coins, long [][] dp){
        if(ind == coins.length){
            if(Amount == 0) return 1;
            return 0;
        } 
        if(dp[ind][Amount] !=-1) return dp[ind][Amount];
        long include=0, notinclude = 0;
        if(Amount >= coins[ind]){
            include = coinChange(ind, Amount-coins[ind], coins, dp);
        }
            notinclude = coinChange(ind+1, Amount, coins, dp);

            return dp[ind][Amount] = include + notinclude;
    }
    
    public long count(int coins[], int N, int sum) {
        long [][]dp = new long[N][sum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }

        return coinChange(0, sum, coins, dp);
    }
}