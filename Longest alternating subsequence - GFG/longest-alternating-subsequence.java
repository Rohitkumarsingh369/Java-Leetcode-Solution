// { Driver Code Starts
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
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.AlternatingaMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int AlternatingaMaxLength(int[] arr)
    {
        // code here
        int n=arr.length;
        /*int las[][]=new int[n][2];
        
        int res=1;
        for(int i=0;i<n;i++){
            las[i][0]=las[i][1]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                
                //if arr[i] is greater, then check arr[j][1]
                if(arr[j]<arr[i] && las[i][0]<las[j][1]+1){
                    las[i][0]=las[j][1]+1;
                }
                
                //if arr[i] is smallerr, then check arr[j][0]
                if(arr[j]>arr[i] && las[i][1]<las[j][0]+1){
                    las[i][1]=las[j][0]+1;
                }
                
            }
            
            //result
            res=Math.max(res,Math.max(las[i][1],las[i][0]));
        }
        
        return res;*/
        
        int inc=1;
        int dec=1;
        
        for(int i=1;i<n;i++){
            
            if(arr[i]>arr[i-1])
            {
                inc=dec+1;
            }
            else if(arr[i]<arr[i-1]){
                dec=inc+1;
            }
        }
        return Math.max(inc,dec);
    }
    
}