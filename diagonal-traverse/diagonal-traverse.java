class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int row=0,col=0,diagonal=1;
        int m=matrix.length;
        int n=matrix[0].length;
        
        int index=0;
        int result[]=new int[m*n];
        while(row<=m && col<=n){
            if(diagonal==0){
                int r,c;
                for(r=row,c=col;r<m && c>=0;r++,c--){
                    result[index++]=matrix[r][c];
                }
                row=r-1; col=c+1;
                    if(row+1<m)
                        row++;
                    else
                    col++;
                diagonal=1;
            }
            else{
                int r,c;
                for(r=row,c=col;r>=0 && c<n;r--,c++){
                    result[index++]=matrix[r][c];
                }
                row=r+1; col=c-1;
                if(col+1<n)
                    col++;
                else 
                    row++;
                diagonal=0;
            }
        }
        return result;
    }
}