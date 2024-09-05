class Solution {
    private static final int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Up, Down, Left, Right
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // Diagonals
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Base case: If the start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // BFS setup
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // x, y, distance
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // BFS Loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // If we've reached the bottom-right corner, return the distance
            if (x == n - 1 && y == n - 1) {
                return distance;
            }

            // Explore all 8 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new position is valid, walkable (value is 0), and not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, distance + 1});
                }
            }
        }

        // If we exit the loop without reaching the destination, return -1
        return -1;
    }
}