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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        // Code here
        int n=arr.length;
        int lis[]=new int[n];
        int lds[]=new int[n];
        
        int i,j;
        for(i=0;i<n;i++)
        {
            lis[i]=1;
            lds[i]=1;
        }
        //compute lis from left to right
        for(i=1;i<n;i++){
            for(j=0;j<i;j++){
                if(arr[i]>arr[j]&& lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
        }
        
        //compute lis from right to left
        for(i=n-2;i>=0;i--){
            for(j=n-1;j>i;j--){
                if(arr[i]>arr[j]&& lds[i]<lds[j]+1){
                    lds[i]=lds[j]+1;
                }
            }
        }
        
        //compute max
        int max=lis[0]+lds[0]-1;
        
        for(i=0;i<n;i++){
            if(lis[i]+lds[i]-1>max){
                max=lis[i]+lds[i]-1;
            }
        }
        
        //return max
        return max;
    }
}