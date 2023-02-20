//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{

 public static int countPaths(int N){

 //code here

 if(N<2){

     return 0;

 }

 long mod=1000000007;

 long  method=0;

 long i=2;

 while(i<=N){

     method=(method*3)%mod;

     if(i%2==0){

         method=(method+3)%mod;

     }

     else{

         method=(method-3)%mod;

     }

     i++;

 }

 return (int)method;

 }

}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends