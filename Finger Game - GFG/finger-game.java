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
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.fingerCount(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int fingerCount(int n){
        // code here
        int r = n % 8;
	if (r == 0)
		return 2;
	if (r < 5)
		return r;
	else
		return 10 - r;
    }
}