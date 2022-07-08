// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        if(n == 1){
            ArrayList<Long> ele = new ArrayList<>();
            ele.add((long)1);
            return ele;
        }
        
        ArrayList<Long> temp = nthRowOfPascalTriangle(n-1);
        ArrayList<Long> mres = new ArrayList<>();
        mres.add((long)1);
        for(int i = 0; i < temp.size()-1; i++){
            mres.add((temp.get(i) + temp.get(i+1))%1000000007);
        }
        mres.add((long)1);
        return mres;
    }
}