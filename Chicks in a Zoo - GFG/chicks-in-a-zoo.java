//{ Driver Code Starts
//Initial Template for Java

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
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        // Code here
         if(N<=1) return 1;

        if(N <= 6){

            return 3 * NoOfChicks(N -1);

        }

        else if ( N == 7){

            return( 3 * NoOfChicks(N-1) - 3 * NoOfChicks(N-6));

        }

        else{

            return (3 * NoOfChicks(N-1) - 2 * NoOfChicks(N-6));

        }
    }
}