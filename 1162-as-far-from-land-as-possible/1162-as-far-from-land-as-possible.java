class Triple{
    int i;
    int j;
    int dist;
    Triple(int i,int j,int dist){
        this.i=i;
        this.j=j;
        this.dist=dist;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int[][] ans=new int[grid.length][grid[0].length];
        Queue<Triple> qu=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans[i][j]=grid[i][j];
                if(grid[i][j]==1)
                    qu.add(new Triple(i,j,0));
            }
        }
        if(qu.isEmpty())
            return -1;
        int maxdist=0;
        while(!qu.isEmpty()){
            Triple t=qu.poll();
            int curri=t.i;
            int currj=t.j;
            maxdist=t.dist;
            int[] diri={-1,0,1,0};
            int[] dirj={0,1,0,-1};
            for(int i=0;i<4;i++){
                int newi=curri+diri[i];
                int newj=currj+dirj[i];
                if(newi>=0 && newj>=0 && newi<ans.length && newj<ans[0].length && ans[newi][newj]==0){
                    ans[newi][newj]=1;
                    qu.add(new Triple(newi,newj,t.dist+1));
                }
            }
        }
        if(maxdist==0)
            return -1;
        return maxdist;
        
    }
}