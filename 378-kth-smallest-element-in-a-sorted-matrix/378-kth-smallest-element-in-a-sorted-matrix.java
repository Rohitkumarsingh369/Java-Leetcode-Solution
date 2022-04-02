class Solution {
    public int kthSmallest(int[][] arr, int k) {
        int n = arr.length;
        int min = arr[0][0];
        int max = arr[n-1][n-1];
        
        while(min!=max){
            int mid = min+(max-min)/2;
            int count = count(arr,mid);
            if(count<k){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    public int count(int[][] arr, int k){
        int c=0;
        int row = 0;
        int col = arr.length-1;
        while(row <arr.length && col>=0){
            if(arr[row][col] <= k){
                c+=col+1;
                row++;
            }else{
                col--;
            }
        }
        return c;
    }
}