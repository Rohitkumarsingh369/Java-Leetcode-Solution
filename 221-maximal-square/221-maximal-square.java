class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        int max=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]=='1')
                 max=1;
        }
        
        for(int i=0;i<col;i++){        
            if(matrix[0][i]=='1')
                 max=1;       
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                   int num1=(int)(matrix[i][j-1]-'0');
                    int num2=(int)(matrix[i-1][j-1]-'0');
                    int num3=(int)(matrix[i-1][j]-'0');
                    int min=Math.min(num1,Math.min(num2,num3))+1;
                    max=Math.max(max,min);
                    matrix[i][j]=(char)(min+'0');
                    
                }
            }
        }
        return max*max;
    }
}