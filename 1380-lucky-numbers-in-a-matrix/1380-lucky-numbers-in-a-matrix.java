class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
       
        List<Integer> result=new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        
        
        for(int i=0;i<row;i++){
            int min_row=matrix[i][0],col_ind=0;
            
            for(int j=1;j<col;j++){
                if(min_row>matrix[i][j]){
                    min_row=matrix[i][j];
                    col_ind=j;
                }
            }
            int k;
            for(k=0;k<row;k++){
                if(min_row<matrix[k][col_ind])
                    break;
            }
            if(k==row){
                result.add(min_row);
            }
        }
        
        return result;
    }
}