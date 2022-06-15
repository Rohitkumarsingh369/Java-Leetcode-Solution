class Solution {
    public int numIslands(char[][] M) {
			boolean visited[][]=new boolean[M.length][M[0].length];
		
		int count=0;
		for(int i=0;i<M.length;i++)
			for(int j=0;j<M[0].length;j++)
				if(M[i][j]=='1' && visited[i][j]==false) {
					DFS(M,i,j,visited);
					++count;
				}
		    return count;
	}
	
	static void DFS(char M[][],int row,int col,boolean[][] visited) {
		
		if ((row<0) ||(row>=M.length)||(col<0)||(col>=M[0].length)||(M[row][col]=='0') || (visited[row][col])==true){
            return;
        }
		
		visited[row][col]=true;
		
		DFS(M,row-1,col,visited);
        DFS(M,row,col-1,visited);
        DFS(M,row+1,col,visited);
        DFS(M,row,col+1,visited);
		
	}
	
}