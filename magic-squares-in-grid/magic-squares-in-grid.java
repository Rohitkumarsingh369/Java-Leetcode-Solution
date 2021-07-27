class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        int res = 0;
        for (int i = 1; i < row - 1; ++i) {
            for (int j = 1; j < col - 1; ++j) {
				// check the center number of a square
                if (grid[i][j] != 5) continue;
				
				// check the other 2 numbers that can form up a line with the center number
                if (grid[i][j - 1] + grid[i][j + 1] != 10) continue;
                if (grid[i - 1][j] + grid[i + 1][j] != 10) continue;
                if (grid[i - 1][j - 1] + grid[i + 1][j + 1] != 10) continue;
                if (grid[i + 1][j - 1] + grid[i - 1][j + 1] != 10) continue;
				
				// check the rows and columns that don't include the center number
                if (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] != 15) continue;
                if (grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] != 15) continue;
                if (grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] != 15) continue;
                if (grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] != 15) continue;
                   
				// check if the current square is valid (distinct numbers from 1 to 9)
                if (isValid(grid, i, j)) res++;
            }
        }
        return res;
    }
    
    private boolean isValid(int[][] grid, int x, int y) {
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        int[] cnt = new int[16];
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cnt[grid[x + dx[i]][y + dy[j]]]++;
            }
        }
        
        for (int n = 1; n <= 9; ++n) {
            if (cnt[n] != 1) return false;
        }
        return true;
    }
}