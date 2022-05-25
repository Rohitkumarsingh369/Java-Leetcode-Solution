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
       /*String small = arr[0];
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
       return small;*/
       
        // code here
        if(n==0 || arr==null)
        return "-1";
        
        String lcp=arr[0]; //Assuming that the first word is the ans (i.e- geeksforgeeks)
        for(int i=1;i<n;i++) //starts checking from the 2nd word in the array that's why i=1
        {
            //will check the length and compare the characters
            String currword=arr[i]; //Stores the current words(for first it's - geeks)
            int j=0;
            while(j<lcp.length() && j<currword.length() && lcp.charAt(j)==currword.charAt(j))
            {
                j++;
            }
            if(j==0) //while loop terminated at first execution only 
            {   //i.e. there's no common prefix may be the words are {hello, world}
                return "-1";
            }
            lcp=currword.substring(0,j);
        }
        return lcp;
   }
}