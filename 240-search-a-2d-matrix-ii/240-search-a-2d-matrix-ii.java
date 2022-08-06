class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       /* if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        
         int i = 0;
        int j = matrix[0].length - 1;
        
        while(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else if(matrix[i][j] < target) i++;
        }
        return false;*/
        
        if(matrix.length==0|| matrix==null)
            return false;
        
        int row=0;
        int col=matrix[0].length-1;
        
        while(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]>target){
                col--;
            }
            else if(matrix[row][col]<target){
                row++;
            }      
        }
        
        return false;
    }
}