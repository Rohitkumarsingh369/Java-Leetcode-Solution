class Solution {
    int m, n;
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ans = Math.max(ans, dfs(grid, r, c));
            }
        }
        return ans;
    }
    int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0) return 0;
        int ans = 1;
        grid[r][c] = 0; // Mark this square as visited
        for (int i = 0; i < 4; i++)
            ans += dfs(grid, r + DIR[i], c + DIR[i+1]);
        return ans;
    }
}