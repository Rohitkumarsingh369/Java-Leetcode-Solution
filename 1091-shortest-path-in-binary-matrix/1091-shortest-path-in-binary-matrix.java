/*class Matrix{
    int r;
    int c;
    Matrix(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        
        int visited[][]=new int[grid.length][grid[0].length];
        for (int[] row : visited) 
            Arrays.fill(row, -1); 
        Queue<Matrix> q=new LinkedList<Matrix>();
        if(grid[0][0]==0){
            q.add(new Matrix(0,0));
            visited[0][0]=1;
        }
        
        while(!q.isEmpty()){
            Matrix m=q.remove();
            int level=visited[m.r][m.c];
            int R[]={-1,-1,-1,0,0,1,1,1};
            int C[]={-1,0,1,-1,1,-1,0,1};
            for(int i=0;i<8;i++){
                int currR=m.r+R[i];
                int currC=m.c+C[i];
                if(currR>=grid.length || currR<0 || currC<0 ||currC>=grid[0].length)
                    continue;
                if(visited[currR][currC]==-1 && grid[currR][currC]==0)
                {
                    visited[currR][currC]=level+1;
                    q.add(new Matrix(currR,currC));
                }
            }
        }
        return visited[grid.length-1][grid[0].length-1];
    }
}*/
class Matrix{
    int row;
    int col;
    
    Matrix(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution{
     public int shortestPathBinaryMatrix(int[][] grid){
         int rowLength=grid.length;
         int colLength=grid[0].length;
         
         if(rowLength==0 || colLength==0)
             return -1;
         
            int visited[][]=new int[rowLength][colLength];
             for (int[] row : visited) 
                Arrays.fill(row, -1);
         
            Queue<Matrix> queue=new LinkedList<Matrix>();
            if(grid[0][0]==0){
                queue.add(new Matrix(0,0));
                visited[0][0]=1;
            }
         
         while(!queue.isEmpty()){
             Matrix mat=queue.remove();
             int level=visited[mat.row][mat.col];
             
             int tempRow[]={-1,-1,-1,0,0,1,1,1};
             int tempCol[]={-1,0,1,-1,1,-1,0,1};
             
             for(int i=0;i<8;i++){
                 int currRow=mat.row+tempRow[i];
                 int currCol=mat.col+tempCol[i];
                 
                 if(currRow>=rowLength || currRow<0 || currCol<0 || currCol>=colLength)
                     continue;
                 
                 if(visited[currRow][currCol]==-1 && grid[currRow][currCol]==0){
                     visited[currRow][currCol]=level+1;
                     queue.add(new Matrix(currRow,currCol));
                 }
             }
         }
         return visited[rowLength-1][colLength-1];
     }
}