// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int arr[], int n)
    {
        // your code here
        // to store the minimum value that is
        // ending up to the current index
        int min_ending_here = 2147483647;
         
        // to store the minimum value encountered
        // so far
        int min_so_far = 2147483647;
         
        // traverse the array elements
        for (int i = 0; i < n; i++)
        {
             
            // if min_ending_here > 0, then it could
            // not possibly contribute to the
            // minimum sum further
            if (min_ending_here > 0)
                min_ending_here = arr[i];
             
            // else add the value arr[i] to
            // min_ending_here
            else
                min_ending_here += arr[i];
             
            // update min_so_far
            min_so_far = Math.min(min_so_far,
                                   min_ending_here);        
        }
         
        // required smallest sum contiguous
        // subarray value
        return min_so_far;
    }
}