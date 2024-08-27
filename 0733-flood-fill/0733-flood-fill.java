class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image; // No need to proceed if colors are the same

        int rows = image.length, cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        image[sr][sc] = newColor; // Start filling with new color

        // Direction vectors for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int r = pixel[0], c = pixel[1];

            // Check all 4 directions
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];

                // Proceed if within bounds and matches old color
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == oldColor) {
                    queue.offer(new int[]{nr, nc});
                    image[nr][nc] = newColor; // Fill with new color
                }
            }
        }

        return image;
    }
}