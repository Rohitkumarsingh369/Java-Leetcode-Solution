// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int a[], int m, int n) {
        // code here.
        
        
        long dp[]=new long[n+1];
        
        dp[0]=1;
        for(int i=0;i<m;i++)//size of the infinity supply given to us
        {
            for(int j=a[i];j<=n;j++) //form the particular supply till the number given to us
            {
                dp[j]+=dp[j-a[i]];
            }
        }
        
        return dp[n];
        
        
        
        /*long coin[]=new long[n+1];
        
        coin[0]=1;
        for(int i=0;i<m;i++){
            
            for(int j=a[i];j<=n;j++){
                
                coin[j]+=coin[j-a[i]];
            }
        }
        
        return coin[n];*/
    }
}