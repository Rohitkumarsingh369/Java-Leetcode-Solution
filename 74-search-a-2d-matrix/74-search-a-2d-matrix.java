class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row=mat.length;
        
        for(int i=0;i<row;i++){
            int left=0;
            int right=mat[i].length-1;
            
            while(left<=right){
                int mid=left+(right-left)/2;
                
                if(mat[i][mid]==target)
                    return true;
                
                else if(mat[i][mid]<target)
                    left=mid+1;
                
                else
                    right=mid-1;
            }
        }
        
        return false;
    }
}