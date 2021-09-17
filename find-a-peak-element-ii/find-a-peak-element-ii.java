class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int i = 0, j = 0;
        
        while(true){
            
            int current = mat[i][j];
            
            int up = i != 0 ? mat[i-1][j] : 0;
            int down = i != mat.length - 1 ? mat[i+1][j] : 0;
            int left =  j != 0 ? mat[i][j-1] : 0;
            int right = j != mat[0].length - 1 ? mat[i][j+1] : 0;
            
            if(up > current){
                i = i-1;
            }else if(down > current) {
                i = i+1;
            }else if(right > current) {
                j = j+1;
            }else if(left > current) {
                j = j -1;
            }else {
                return new int[] {i,j};
            }
            
        }
        
    }
}