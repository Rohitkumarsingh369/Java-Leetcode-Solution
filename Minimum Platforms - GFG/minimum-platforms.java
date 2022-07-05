// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dept[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dept);
        
        int i=1,j=0;
        int platform_need=1,result=1;
        
        while(i<n && j<n){
            if(arr[i]<=dept[j]){
                platform_need++;
                i++;
            }
            else if(arr[i]>dept[j]){
                platform_need--;
                j++;
            }
            
            result=Math.max(platform_need,result);
        }
        
        return result;
        
    }
    
}

