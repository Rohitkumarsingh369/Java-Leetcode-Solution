//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        ArrayList<Integer> ans=new ArrayList<>();
        // code here 
        //before diagonal including middile diagonal
        for(int i=0; i<N; i++)
        {
            int t=0;
            for(int j=i; j>=0; j--)
            {
                ans.add(A[t][j]);
                t++;
            }
        }
        
        //after diagonal excluding middile diagonal
        for(int i=1; i<N; i++)
        {
            int t=i;
            for(int j=N-1; j>=i; j--)
            {
                ans.add(A[t][j]);
                t++;
            }
        }
        
        return ans;
    }
}