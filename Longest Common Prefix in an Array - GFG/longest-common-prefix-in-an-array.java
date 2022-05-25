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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
       String small = arr[0];
       //find smallest string length
       for(int i=1; i<n; i++)
       {
           String word = arr[i];
           if(word.length()<small.length())
           {
               small = word;
           }
       }
       //iterate till the length of small string
       for(int i=0; i<small.length(); i++)
       {
           //iterate through array
           for(int j=0; j<n; j++)
           {
               String word = arr[j];
               if(small.charAt(i)!=word.charAt(i))
               {
                   if(i==0)
                       return "-1";
                   return small.substring(0, i);
               }
           }
       }
       return small;
   }
}