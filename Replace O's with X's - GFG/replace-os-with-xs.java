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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static char[][] fill(int n, int m, char a[][]) {
        // code here
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                if (a[i][j] == 'O' && (i == 0 || j == 0 || i == n-1 || j == m-1)) {
                    fillDfs(visited, 2, i, j, a);
                } else if (a[i][j] == '1') {
                    visited[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 2) {
                    // do nothing
                } else {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
    
    static void fillDfs(int[][] visited, int val, int i, int j, char[][] a) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length) {
            return;
        }
        if (visited[i][j] != 0) {
            return;
        }
        if (a[i][j] == 'X') {
            return;
        }
        // now a[i][j] == 'O'
        visited[i][j] = val;
        fillDfs(visited, val, i+1, j, a);
        fillDfs(visited, val, i-1, j, a);
        fillDfs(visited, val, i, j+1, a);
        fillDfs(visited, val, i, j-1, a);
    }
}