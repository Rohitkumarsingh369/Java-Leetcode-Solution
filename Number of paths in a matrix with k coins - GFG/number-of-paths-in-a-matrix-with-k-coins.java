// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  K = Integer.parseInt(read.readLine());
            int  N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<N;i++){
                for(int j = 0;j<N;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(N, K, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    long dp[][][];
    long numberOfPath(int N, int k, int [][]arr) {
        // code here
        int max=100;
        int m=arr.length;
        int n=arr[0].length;
        dp=new long[m][n][max];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<max;d++){
                    dp[i][j][d]=-1;
                }
            }
        }
        
        return pathcount(arr,m-1,n-1,k);
    }
    
    long pathcount(int arr[][],int m,int n,int k){
        if(m<0||n<0||k<0){
            return 0;
        }
        
        if(m==0 &&n==0)
          return (k==arr[m][n])?1:0;
          
         
        if(dp[m][n][k]!=-1)
            return dp[m][n][k];
            
        
        dp[m][n][k]= pathcount(arr,m-1,n,k-arr[m][n])+pathcount(arr,m,n-1,k-arr[m][n]);
        
        return dp[m][n][k];
    }
}