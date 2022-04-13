class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][]=new int[n][n];
        int i,k=0,l=0;
        int num=1;
        int m=mat[0].length;
        while(k<m && l<n){
            //top row
        for(i=l;i<n;i++)
            mat[k][i]=num++;
        k++;
        
        //last column
        for(i=k;i<m;i++)
            mat[i][n-1]=num++;
        
        n--;
        
        //bottom row
        if(k<m){
            for(i=n-1;i>=l;i--)
                mat[m-1][i]=num++;
            m--; 
        }
        //first column
        if(l<n){
            for(i=m-1;i>=k;i--)
                mat[i][l]=num++;
            l++; 
        }
        }
        return mat;
    }
}