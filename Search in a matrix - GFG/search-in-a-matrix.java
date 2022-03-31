// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}// } Driver Code Ends


class Sol
{
    public static int matSearch(int mat[][], int N, int M, int target)
    {
        int row=mat.length;
        int col=mat[0].length;
        
        if(mat[0][0]>target || mat[row-1][col-1]<target){
            return 0;
        }
    
        int i=row-1;  //for travesing the row
        int j=0;  //for traversing the column
        
        while(i>=0 && j<col){
            int num=mat[i][j];
            
            if(num>target){
                i--;
            }
            else if(num<target){
                j++;
            }
            else if(num==target){
                return 1;
            }
        }
        return 0;
    }
}