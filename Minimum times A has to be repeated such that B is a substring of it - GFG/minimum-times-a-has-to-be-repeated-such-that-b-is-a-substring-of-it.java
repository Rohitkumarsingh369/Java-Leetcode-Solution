//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int x=-1;
        //finding first char of B in A
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==B.charAt(0)){
                x=i;
                break;
            }
        }
        
        // if the first char of B not found
        if(x==-1) return x;
        
        //min number of folds A needs to repeat
        int y=(B.length()-x)/A.length();
        
        
        //merging strings
        int i=y;
        String S="\0"; 
        while(i>0){
            S+=A;
            i--;
        }
        // System.out.println(S+" "+S+A);
        //conclusion
        if(S.contains(B))
            return y;
        else if((S+A).contains(B))
            return y+1;
        else if((S+A+A).contains(B))
            return y+2;
        else 
            return -1;
        
    }
};