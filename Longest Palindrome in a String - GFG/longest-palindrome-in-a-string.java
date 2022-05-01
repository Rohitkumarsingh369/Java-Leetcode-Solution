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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        int res = 0;
            int temp = 0;
            int mid = 0;
            for(int i = 0; i < s.length(); i++){
                temp = 1 + extend(s, i - 1, i + 1);
                temp = Math.max(temp, extend(s, i, i + 1));
                if(res < temp){
                    res = Math.max(temp, res);
                    mid = i;
                }
            }
            //System.out.println(mid);
            if(res % 2 == 0) return (s.substring(mid + 1 - res/2, mid + 1 + res/2));
            return s.substring(mid - res/2 , mid + res/2 + 1);
    }
    public static int extend(String s, int start, int end){
            if(start >= 0 && end < s.length()){
                if (s.charAt(start) == s.charAt(end)){
                    return 2 + extend(s, start - 1, end + 1);
                }
            }
            return 0;
        } 
}