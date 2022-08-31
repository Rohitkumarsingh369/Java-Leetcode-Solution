class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];
        
        for (int i = 0; i < n; i++) startTrace(0, i, heights, toPacific);
        for (int i = 0; i < m; i++) startTrace(i, 0, heights, toPacific);
        for (int i = 0; i < n; i++) startTrace(m-1, i, heights, toAtlantic);
        for (int i = 0; i < m; i++) startTrace(i, n-1, heights, toAtlantic);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (toPacific[i][j] && toAtlantic[i][j])  result.add(List.of(i, j));
        return result;
    }
    
    private void startTrace(int row, int col, int[][] heights, boolean[][] reach) {
        if (reach[row][col]) return;
        reach[row][col] = true;
        trace(row-1, col, heights[row][col], heights, reach);
        trace(row+1, col, heights[row][col], heights, reach);
        trace(row, col-1, heights[row][col], heights, reach);
        trace(row, col+1, heights[row][col], heights, reach);
    }
    
    private void trace(int row, int col, int h, int[][] heights, boolean[][] reach) {
        if (row < 0 || row == heights.length || col < 0 || col == heights[0].length) return;
        if (reach[row][col] || heights[row][col] < h) return;
        reach[row][col] = true;
        trace(row-1, col, heights[row][col], heights, reach);
        trace(row+1, col, heights[row][col], heights, reach);
        trace(row, col-1, heights[row][col], heights, reach);
        trace(row, col+1, heights[row][col], heights, reach);
    }
}