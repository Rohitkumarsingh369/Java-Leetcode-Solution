class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static class pair{
        int a,b;
        public  pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int id=2;
        Map<Integer,Integer> map=new HashMap<>();
        boolean[][] visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int val=bfs(i,j,id,grid);
                    map.put(id++,val);
                }
            }
        }
        
        int ans=Integer.MIN_VALUE;
        map.put(0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
				//if grid[i][j]==0 check the area of adjacent cells stored in the map
                    Set<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int x=i+dx[k];
                        int y=j+dy[k];
                        if(inside(x,y,n)){
                            set.add(grid[x][y]);
                        }
                    }
                    int a=1;//considering the current cell as an island 
                    for(int val:set){
                       a+=map.get(val); 
                    }
                    if(a>ans)ans=a;
                }
            }
        }
        return ans==Integer.MIN_VALUE?n*n:ans;// check if all th values are 1
    }
    static int bfs(int i,int j,int index,int[][] grid){
        int n=grid.length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        int area=1;
        grid[i][j]=index;
        Set<Integer> set=new HashSet<>();
        set.add(i*n+j);//could have  use an array but declaring the same array of o(n**2) space complexity for every zero will not be a good idea 
        while(!q.isEmpty()){
            pair val=q.poll();
            for(int k=0;k<4;k++){
                int x=val.a + dx[k];
                int y=val.b + dy[k];
                int val2=x * n + y;
                if(inside(x,y,n) && grid[x][y]==1 && !set.contains(val2)){
                    set.add(val2);
                    q.add(new pair(x,y));
                    grid[x][y]=index;
                    area++;
                }
            }
        }
        System.out.println(area);
        return area;
    }
    static boolean inside(int i,int j,int n){
        if(i<0 || i>=n || j<0 || j>=n)return false;
            return true;
    }
}