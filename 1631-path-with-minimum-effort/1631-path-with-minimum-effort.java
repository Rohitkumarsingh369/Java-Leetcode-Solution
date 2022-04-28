class Solution {
   /* public int minimumEffortPath(int[][] heights) {
        
        int n=heights.length;
        int m=heights[0].length;
        
        if(n==1 && m==1)
            return 0;
        
        int efforts[][]=new int[n][m];//stores the minimum effots required to travel upto a given cell
        for(int row[]:efforts)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        PriorityQueue<int[]>pq=new PriorityQueue<int[]>((t1,t2)->(t1[2]-t2[2]));//returns cell with minimum efforts
        
        pq.offer(new int[]{0,0,0});
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};//direction to travel
        
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int curr_row=curr[0];
            int curr_col=curr[1];
            int curr_wt=curr[2];
            for(int x[]:dir)
            {
                int nrow=curr_row+x[0];
                int ncol=curr_col+x[1];
                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m)
                    continue;
                int wt = Math.max(curr_wt,Math.abs(heights[nrow][ncol]-heights[curr_row][curr_col]));//getting max absolute value
                //updating the minimum effort
                if(wt<efforts[nrow][ncol])
                {
                    efforts[nrow][ncol]=wt;
                    pq.offer(new int[]{nrow,ncol,wt});
                }
                
            }
        }
        return efforts[n-1][m-1]; 
    }*/
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = (int) 10e6;
        while (left < right) {
            int middle = (right + left) / 2;
            if (dfs(heights, new boolean[heights.length][heights[0].length], 0, 0, heights[0][0], middle))
                right = middle;
            else
                left = middle + 1;
        }
        return right;
    }


    private boolean dfs(int[][] heights, boolean[][] visited, int row, int column, int lastHeight, int threshold) {
        if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length ||
                visited[row][column] || Math.abs(heights[row][column] - lastHeight) > threshold)
            return false;

        visited[row][column] = true;

        return ((row == heights.length - 1 && column == heights[0].length - 1)
                || dfs(heights, visited, row + 1, column, heights[row][column], threshold)
                || dfs(heights, visited, row - 1, column, heights[row][column], threshold)
                || dfs(heights, visited, row, column + 1, heights[row][column], threshold)
                || dfs(heights, visited, row, column - 1, heights[row][column], threshold));
    }
}