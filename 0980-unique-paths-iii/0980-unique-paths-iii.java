class Solution {
    int res = 0, empty = 1, sx, sy, ex, ey;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    public void dfs(int[][] grid, int x0, int y0) {
        if (check(grid, x0, y0) == false) return;
        if (x0 == ex && y0 == ey) {
            if (empty == 0) res++;
            return;
        }
        grid[x0][y0] = -2;
        empty--;
        dfs(grid, x0 + 1, y0);
        dfs(grid, x0 - 1, y0);
        dfs(grid, x0, y0 + 1);
        dfs(grid, x0, y0 - 1);
        grid[x0][y0] = 0;
        empty++;
    }

    public boolean check(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        return 0 <= i && i < m && 0 <= j && j < n && grid[i][j] >= 0;
    }
}