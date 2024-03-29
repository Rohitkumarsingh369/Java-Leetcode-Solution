class Solution {
    public int countNegatives(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        
        int i=row-1;
        int j=0;
        
        int count=0;
        while(i>=0 && j<col){
            int num=grid[i][j];
            
            if(num<0)
            {
                count+=col-j;
                i--;
            }
            else {
                j++;
            }
        }
        
        return count;
        
        
        
    }
}