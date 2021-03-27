class Solution {
    public int diagonalSum(int[][] mat) {
        int row=mat.length;
		int col=mat[0].length-1;
		
		int rightsum=0,leftsum=0;
		for(int i=0;i<row;i++)
		{
			leftsum+=mat[i][i];
			
			if(i!=col)
			{
				rightsum+=mat[i][col];
			}
			col--;
		}
        
        return (leftsum+rightsum);
    }
}