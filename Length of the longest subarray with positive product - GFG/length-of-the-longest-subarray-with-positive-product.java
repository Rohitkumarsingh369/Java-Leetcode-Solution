//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
         int start =0, len =0;
        boolean pos = true;
        
        for(int end=0; end<=n; end++) {   
            if(end != n && arr[end] != 0) {
                if(arr[end] < 0) pos = !pos;
                if(pos) len = Math.max(len, end-start+1);
            }
            else {
                while(start < end) {
                    if(arr[start] < 0) pos = !pos;
                    if(pos) len = Math.max(len, end-start-1);
                    start++;
                }
                start = end+1;
                pos = true;
            }}
        return len;
    }
   
}