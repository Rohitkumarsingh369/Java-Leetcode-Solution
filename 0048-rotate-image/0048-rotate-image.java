
class Solution {
    public void rotate(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //ste2-> rotate the element row wise
        for(int i=0;i<row;i++){
            for(int j=0;j<row/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][row-1-j];
                mat[i][row-1-j]=temp;
            }
        }
    }
}