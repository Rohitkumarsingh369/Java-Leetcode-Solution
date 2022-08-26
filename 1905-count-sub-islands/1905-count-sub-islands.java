class Solution {
   /* int n,m;
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};
    int ans=1;
    void dfs(int x,int y,int[][] vis,int[][] g1,int[][] g2)
    {
        vis[x][y]=1;
        ans*=g1[x][y];
        for(int i=0;i<4;i++)
        {
            int ind1=x+dx[i];
            int ind2=y+dy[i];
            if(ind1<0 || ind2<0 || ind1>=n || ind2>=m)
                continue;
            if(g2[ind1][ind2]==0)
                continue;
            if(vis[ind1][ind2]==0)
                dfs(ind1,ind2,vis,g1,g2);
                
       }
        
        
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid1.length;
        m=grid1[0].length;
        int i,j,cnt=0;
        int[][] vis = new int[n][m];
        for(i=0;i<n;i++)
            for(j=0;j<m;j++)
                vis[i][j]=0;
        
         for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(grid2[i][j]==1 && vis[i][j]==0)
                {
                     ans=1;
                    dfs(i,j,vis,grid1,grid2);
                    if(ans==1)
                    {cnt++;
                    }
                }
            }
        }
        return cnt;
    }*/
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        int[] dir = {1, 0, -1, 0, 1};
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid2[i][j] == 0 )
                    continue;
                
                Queue<int[]> queue = new LinkedList<>();
                boolean flag = true;
                grid2[i][j] = 0;
                
                queue.add(new int[] {i, j});
                
                while(!queue.isEmpty()) {
                    int[] vtx = queue.remove();
                    
                    if(grid1[vtx[0]][vtx[1]] == 0)
                        flag = false;
                    
                    for(int k = 0; k < 4; ++k) {
                        int x = vtx[0] + dir[k];
                        int y = vtx[1] + dir[k + 1];
                        
                        if(x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                            grid2[x][y] = 0;
                            
                            queue.add(new int[] {x, y});
                        }
                    }
                }
                
                if(flag)
                    ++count;
            }
        }
        
        return count;
    }
}