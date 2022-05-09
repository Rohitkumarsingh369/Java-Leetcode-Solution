// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int k = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSum(A, n, k));
                }
        }
}    // } Driver Code Ends


class Solution{

public int minSum(int arr[], int N, int K) 
{ 
 int [][]dp=new int[N+1][K+1];
 for(int i=0;i<=N;i++)
 {
     for(int j=0;j<=K;j++)
     {
         dp[i][j]=Integer.MAX_VALUE;
         if(i==0||j==0)
         dp[i][j]=0;
     }
 }
 for(int i=1;i<=N;i++)
 {
     dp[i][1]=arr[i-1];
 }
 for(int k=2;k<=K;k++)
 {
     for(int i=2;i<=N;i++)
     {
     int mn=Integer.MAX_VALUE;
         for(int j=1;j<i;j++)
         {
             if(arr[i-1]>=arr[j-1] &&dp[j][k-1]!=Integer.MAX_VALUE)
             {
                mn=Math.min(mn,arr[i-1]+dp[j][k-1]) ;
             }
         }
         dp[i][k]=mn;
     }
 }
 int res=Integer.MAX_VALUE;
 for(int i=1;i<=N;i++)
 {
     res=Math.min(res,dp[i][K]);
 }
 if( res==Integer.MAX_VALUE)
 return -1;
 return res;
} 
}