class Solution {
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the distance matrix with a large value and enqueue all '1' cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0; // Distance for cells with '1' is 0
                } else {
                    distance[i][j] = Integer.MAX_VALUE; // Initially, set all distances to a large value
                }
            }
        }

        // Perform BFS from all '1' cells
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Explore the 4 neighboring cells
            for (int k = 0; k < 4; k++) {
                int newRow = row + rowDir[k];
                int newCol = col + colDir[k];

                // Check if the new position is within bounds and if a shorter distance can be found
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    if (distance[newRow][newCol] > distance[row][col] + 1) {
                        distance[newRow][newCol] = distance[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return distance;
    }
}