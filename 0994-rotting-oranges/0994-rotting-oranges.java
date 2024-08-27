class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize the queue with all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;  // No fresh oranges, no time needed

        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // BFS to spread the rot
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenSpread = false;
            
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0], y = orange[1];
                
                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;  // Rot the fresh orange
                        queue.offer(new int[]{nx, ny});
                        freshCount--;
                        rottenSpread = true;
                    }
                }
            }
            
            if (rottenSpread) {
                minutes++;
            }
        }
        
        return freshCount == 0 ? minutes : -1;
    }

}