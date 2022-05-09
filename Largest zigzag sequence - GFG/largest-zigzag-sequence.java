// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    M[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }    
            Solution ob = new Solution();
            System.out.println(ob.zigzagSequence(n, M));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int max=100;
    static int dp[][]=new int[max][max];
    static int zigzagSequence(int n, int mat[][]){
        // code here
        
        for(int i=0;i<max;i++){
            for(int j=0;j<max;j++){
                dp[i][j]=-1;
            }
        }
        
        int res=0;
        for(int j=0;j<n;j++){
            res=Math.max(res,largestzigzag(mat,0,j,n));
        }
        
        return res;
    }
    
    static int largestzigzag(int mat[][],int i,int j,int n){
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        if(i==n-1)
            return dp[i][j]=mat[i][j];
            
        
        int zzs=0;
        
        for(int k=0;k<n;k++){
            if(k!=j){
                zzs=Math.max(zzs,largestzigzag(mat,i+1,k,n));
            }
        }
        
        return dp[i][j]=zzs+mat[i][j];
    }
}