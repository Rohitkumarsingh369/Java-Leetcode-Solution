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
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countTriplets(int[] nums){
        // code here
        int n = nums.length;
        //If the array contains less than 3 elements then there will be no magic triplets so return 0
        if(n <= 2){
            return 0;
        }
        int magicTripletsCount = 0;
        for(int i = 1;i<n-1;i++){
            //For every index count the number of smaller elements on the left side
            int small = 0,large = 0;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    small++;
                }
            }
            //For every index count the number of larger elements on the right side
            for(int k=i+1;k<n;k++){
                if(nums[k] > nums[i]){
                    large++;
                }
            }
            //Add the number of triplets to the answer
            magicTripletsCount += small*large;
        }
        return magicTripletsCount;
    }
}