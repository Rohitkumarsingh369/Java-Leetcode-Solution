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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.countFactors(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static int countFactors(int N) {
        //code here'
        
        int count=0;
        int root=(int)(Math.sqrt(N));
        for(int i=1;i<Math.sqrt(N);i++){
            if(N%i==0){
                count++;
            }
        }
        if(root*root==N){
            return 2*count+1;
        }
     return 2*count;
    }
}