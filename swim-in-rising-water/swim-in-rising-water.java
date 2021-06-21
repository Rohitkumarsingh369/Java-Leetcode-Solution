class Solution {
    
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        
        int low = grid[0][0];   // min time needed is 1st square where we stand, we cannot move till T reaches grid[0][0]
        int high = n*n - 1;     // max time needed is the max value present in grid (provided in constraint)
        
        
        // Apply Binary Search for checking if possile result lies in the intervals.
        
        while (low < high) {
            
            int mid = low + ((high - low) >> 1);
            
            // Start search from grid[0][0] 
            
            /* Note:

               Create boolean visited array in while loop as we want new search everytime for particular time T.
               
                Otherwise, when we are searching for range (0,24) it will make some squares visited.
                So, next time for checking dfs for range (0,12) or (13,24) it will not check those squares.
                
                So, write code for creating a new boolean array in while loop, but not before while loop.
              
            */
            
            boolean visited[][] = new boolean[n][n];
            
            if (dfs(grid, 0, 0, mid, visited)) {
                
                high = mid;
                
            } else {
                
                low = mid + 1;
                
            }
            
        }
        
        return low;
        
    }
    
    
    // DFS function to check if solution exists for given time T
    
    private boolean dfs (int grid[][], int row, int col, int time, boolean visited[][]) {
        
        int n = grid.length;
        
        // Corner Cases / Exit Return cases / Solution not possible
        
        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] > time) {
            
            return false;   // If current square elevation > T, then wait till time for that elevation.
            
        }
        
        visited[row][col] = true;         // Mark the square as visited
        
        if (row == n-1 && col == n-1) {
            return true;                  // Return true, as for some DFS, result is obtained.
        }
        
        // Check for other 4 directional scenarios and return true if Any of them is true.
        
        return dfs(grid, row - 1, col    , time, visited) || 
               dfs(grid, row + 1, col    , time, visited) ||
               dfs(grid, row    , col - 1, time, visited) || 
               dfs(grid, row    , col + 1, time, visited);
        
    }
    
    
    
}