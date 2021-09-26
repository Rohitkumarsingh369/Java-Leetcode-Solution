class Solution {
    int INF = 0x3f3f3f3f;
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    

    public int shortestPath(int[][] grid, int k) {
        //init
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        if(m == 1 && n == 1) return ret;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(visited[i], INF);
        }
        visited[0][0] = 0;
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        while(!queue.isEmpty()) {
            ret++;
            int cnt = queue.size();
            while(cnt-- > 0) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                int ori_k = cur[2];
                for(int i = 0; i < dirs.length; i++) {
                    int cur_row = row + dirs[i][0];
                    int cur_col = col + dirs[i][1];
                    if(outOfRange(cur_row, cur_col, m, n)) continue;
                    if(cur_row == m-1 && cur_col == n-1) return ret;
                    int cur_k = ori_k + (grid[cur_row][cur_col] == 1 ? 1 : 0);
                    if(cur_k > k || cur_k >= visited[cur_row][cur_col]) {
                        continue;
                    }
                    //update visited
                    visited[cur_row][cur_col] = cur_k;
                    queue.offer(new int[]{cur_row,cur_col,cur_k});
                }
            }
        }
        return -1;
    }
    
    private boolean outOfRange(int row, int col, int m, int n) {
        return row < 0 || col < 0 || row >= m || col >= n;
    }
}