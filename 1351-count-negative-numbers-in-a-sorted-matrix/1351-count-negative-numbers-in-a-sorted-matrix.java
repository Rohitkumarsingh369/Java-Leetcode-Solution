class Solution {
    public int countNegatives(int[][] grid) {
        /*int row=grid.length;
        int col=grid[0].length;
        
        int i=row-1;
        int j=0;
        
        int count=0;
        while(i>=0 && j<col){
            int num=grid[i][j];
            
            if(num<0)
            {
                count+=row-j;
                i--;
            }
            else if(num>0){
                j++;
            }
        }
        
        return count;*/
        
        int rows = grid.length;
int columns = grid[0].length;

	//start position in the left bottom (but it can be right top)
    int i = rows - 1;
    int j = 0;
    
    int result = 0;
    while(i>=0 && j<columns) {
        if(grid[i][j]<0) {
			i--;                         //switch to the upper row
			result += columns - j;       //add to result count of all numbers from current ot the end of row (because of sorted row)
        } else {
            j++;                         //switch to the right column
        }
    }
    
    return result;
    }
}