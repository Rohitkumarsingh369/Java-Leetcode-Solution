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
            int ans = ob.ZigZagMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int ZigZagMaxLength(int[] nums)
    {
        // code here
        
        int lastsign=0,length=1;
        
        for(int i=1;i<nums.length;i++){
            int sign=signum(nums[i]-nums[i-1]);
            
            if(lastsign!=sign && sign!=0){
                lastsign=sign;
                length++;
            }
        }
        
        return length;
    }
    
    public int signum(int n){
        if(n!=0){
            return n>0?1:-1;
        }
        else return 0;
    }
}