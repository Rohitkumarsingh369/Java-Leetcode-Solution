//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.lcmTriplets(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long lcmTriplets(long n) {
        // code here
        if(n<=2) return n;
        
        if(n%2!=0)
            return n*(n-1)*(n-2);
        else{
            if(n%3==0){
                return (n-1)*(n-2)*(n-3);
            }
            else
                return n*(n-1)*(n-3);
        }
    }
}