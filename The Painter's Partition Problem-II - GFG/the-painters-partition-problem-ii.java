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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    
    static boolean helper(int[] arr,long m,int k){
        long painters=1;
        long time=0;
        for(int i=0;i<arr.length;i++){
            if(time+arr[i]<=m){
                time+=arr[i];
            }else{
                painters++;
                if(painters>k || arr[i]>m){
                    return false;
                }
                time=arr[i];
            }
        }
        return true;
    }
    static long minTime(int[] arr,int n,int k){
        //code here
        long ans=0;
        long s=0;
        long e=0;
        for(int i=0;i<arr.length;i++) e+=arr[i];
        
        while(s<=e){
            long m=s+(e-s)/2;
            if(helper(arr,m,k)){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        
        return ans;
    }
}

