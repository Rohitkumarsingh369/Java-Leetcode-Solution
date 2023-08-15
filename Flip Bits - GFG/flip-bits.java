//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int arr[], int n) {
        // Your code goes here
        int total=0,currtotal=0,max=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) total++;
        }
        max=total;
        for(int i=0;i<n;i++){
            if(arr[i]==1&&currtotal!=0){
                currtotal-=1;
            }else if(arr[i]==0){
                currtotal+=1;
                max=Math.max(max,(currtotal+total));
            }
        }
        return max;
    }
}