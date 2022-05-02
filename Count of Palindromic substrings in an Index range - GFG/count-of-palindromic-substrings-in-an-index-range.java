// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next ();
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();
            if (q1 > q2){
                int temp = q1;
                q1 = q2;
                q2 = temp;
            }
    		System.out.println (new Sol().countPalinInRange (n, s, q1, q2));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countPalinInRange (int N, String s, int left, int right)
    {
        // your code here 
        
        int length=s.length();
        
        int dp[][]=new int[length+1][length+1];
        int ispalin[][]=new int[length+1][length+1];
        
        for(int i=0;i<=length;i++){
            for(int j=0;j<=length;j++){
                dp[i][j]=ispalin[i][j]=0;
            }
        }
        
        //loop for starting index
        for(int i=length-1;i>=0;i--){
            dp[i][i]=1;
            ispalin[i][i]=1;
            
            //loop for ending index
            
            for(int j=i+1;j<length;j++){
               // ispalin[i][j] = (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || (ispalin[i + 1][j - 1]) != 0)) ? 1 : 0;
                    ispalin[i][j]=(s.charAt(i)==s.charAt(j) &&(i+1>j-1||ispalin[i+1][j-1]!=0))?1:0;
                /* dp[i][j] will be addition of number
                of palindromes from i to j-1 and i+1
                to j subtracting palindromes from i+1
                to j-1 (as counted twice) plus 1 if
                str(i..j) is also a palindrome */
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1] + ispalin[i][j];
            }
        }
        
        return dp[left][right];
    }
}