//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
        int countR = 0,countG = 0,countB = 0;
       for(int i=0;i<n;i++){
           if(a[i].equals("R")) countR++;
           else if(a[i].equals("G")) countG++;
           else if(a[i].equals("B")) countB++;
       }
       if(countR == n || countG == n || countB == n) 
        return n;
       else if((countR % 2==0 && countG % 2==0 && countB%2==0) || (countR%2==1 && countG%2==1 && countB%2==1)) 
        return 2;
       else
        return 1;
    }
}