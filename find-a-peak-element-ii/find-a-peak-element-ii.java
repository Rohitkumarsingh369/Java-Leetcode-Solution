class Solution{
public int[] findPeakGrid(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    for(int i = 0; i < n; i++){
        int start = 0;
        int end = m;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            int num = mat[i][mid];
            int top = i == 0 ? -1 : mat[i-1][mid];
            int bottom = i == n-1 ? -1 : mat[i+1][mid];
            int left = mid == 0 ? -1 : mat[i][mid - 1];
            int right = mid == m-1 ? -1 : mat[i][mid + 1];
            
            if(num > top && num > bottom && num > left && num > right){
                return new int[]{i, mid};
            }else if(num < right){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }
    
    return new int[]{-1, -1};
    
}
}