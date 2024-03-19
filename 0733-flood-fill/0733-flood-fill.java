class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor=image[sr][sc];
        int ans[][]=image;

        int delRow[]=new int[]{-1,0,1,0};
        int delCol[]=new int[]{0,1,0,-1};

        dfs(sr,sc,image,ans,iniColor,newColor,delRow,delCol);

        return ans;
    }
    
    private  void dfs(int row,int col,int[][]image,int [][]ans,int iniColor,int newColor,int []delRow,int []delCol){
        ans[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m &&
                image[nRow][nCol]==iniColor && ans[nRow][nCol]!=newColor){
                    dfs(nRow,nCol,image,ans,iniColor,newColor,delRow,delCol);
                }
        }
    }
}