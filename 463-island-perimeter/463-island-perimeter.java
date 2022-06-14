/*class Solution {
   public int islandPerimeter(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        
        int perimeter=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    
                    perimeter+=4;
                    //backward
                    if(j-1>=0 && grid[i][j-1]==1)
                        perimeter--;
                
                    //forward
                    if(j+1<col && grid[i][j+1]==1)
                        perimeter--;
                
                    //upward
                    if(i-1>=0 && grid[i-1][j]==1)
                        perimeter--;
                
                    //downward
                    if(i+1<row && grid[i+1][j]==1)
                        perimeter--;
                    
                }
            }
        }
        
        return perimeter;
        
    }
}*/

/*
loop over the matrix and count the number of islands;
if the current dot is an island, count if it has any right neighbour or down neighbour;
the result is islands * 4 - neighbours * 2*/
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
