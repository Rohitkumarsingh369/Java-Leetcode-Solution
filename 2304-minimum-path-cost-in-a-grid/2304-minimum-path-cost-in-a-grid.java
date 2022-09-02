class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        for(int i = grid.length-2 ; i >=0 ; i--) {
            
            for(int j = 0 ; j< grid[i].length ; j ++) {
                int temp = Integer.MAX_VALUE;
                for(int k = 0 ; k < grid[i].length ; k++)
                {
                    temp = Math.min(temp,grid[i][j]+moveCost[grid[i][j]][k] + grid[i+1][k]);
                }
                grid[i][j] = temp;
            }
        }
        int temp = grid[0][0];
        for(int i = 1 ; i < grid[0].length ; i++) {
            temp = Math.min(temp,grid[0][i]);
        }
        
        return temp;
    }
}