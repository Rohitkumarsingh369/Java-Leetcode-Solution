//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    static int checkCompressed(String s, String t) {

        // code here

        int i=0;

        int j=0;

        while(i<s.length() && j<t.length()){

              if(s.charAt(i)==t.charAt(j)){

                 i++;

                 j++;

                 continue;

             }

             if(Character.isDigit(t.charAt(j))==false && s.charAt(i)!=t.charAt(j)) return 0;

              

             int cnt=0;

             while(j<t.length() &&  Character.isDigit(t.charAt(j))){

                 cnt=cnt*10+(t.charAt(j)-'0');

                 j++;

             }

             i+=cnt;

        }

        if(i==s.length() && j==t.length()){

            return 1;

        }

        else{

            return 0;

        }  
    }

    }