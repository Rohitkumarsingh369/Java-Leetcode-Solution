//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {

     private static int MOD = 1000000007;

     static int nthFibonacci(int n) {
  
        int a = 0, b = 1;
        if(n == 0) 
            return a;
        for(int i = 2; i <= n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        
        return b;
    }
}