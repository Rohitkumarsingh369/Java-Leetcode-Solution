// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int [][] mem=new int[m][n];
        int longestpath=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int path=dfs(matrix,m,n,i,j,mem);
                longestpath=Math.max(longestpath,path);
            }
        }
        return longestpath;
    }
    public int dfs(int [][]matrix,int m,int n,int i,int j,int [][]mem){
        if(mem[i][j]>0)
            return mem[i][j];
        int max=0;
        for(int []d:dir){
            int x=i+d[0], y=j+d[1];
            if(x>=0 && y>=0 & x<m && y<n && matrix[x][y]>matrix[i][j]){
                max=Math.max(max,dfs(matrix,m,n,x,y,mem));
            }
        }
        mem[i][j]=max+1;
        return max+1;
    }
}