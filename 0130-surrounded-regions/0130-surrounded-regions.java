class Solution {
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;

        // Step 1: Mark all 'O's connected to the border
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0, n, m);
            if (board[i][m - 1] == 'O') dfs(board, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j, n, m);
            if (board[n - 1][j] == 'O') dfs(board, n - 1, j, n, m);
        }

        // Step 2: Flip all remaining 'O's to 'X's and restore border-connected 'O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Flip surrounded 'O' to 'X'
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';  // Restore non-surrounded 'O'
                }
            }
        }
    }

    // Helper function for DFS
    private static void dfs(char[][] board, int row, int col, int n, int m) {
        // Mark the current cell as visited
        board[row][col] = '#';

        // Explore in all 4 possible directions
        for (int k = 0; k < 4; k++) {
            int newRow = row + rowDir[k];
            int newCol = col + colDir[k];

            // Check if the new position is within bounds and if it's an 'O'
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O') {
                dfs(board, newRow, newCol, n, m);
            }
        }
    }
}