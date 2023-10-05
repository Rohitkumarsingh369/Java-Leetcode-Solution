class Solution {
    public int kthSmallest(int[][] arr, int k) {
        int n = arr.length;
        int min = arr[0][0];
        int max = arr[n-1][n-1];
        
        while(min<=max){
            int mid = min+(max-min)/2;
            int count = count(arr,mid);
            if(count<k){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return min;
    }
    public int count(int[][] arr, int k){
        int c=0;
        int row = arr.length-1;
        int col = 0;
        while(row >=0 && col<arr.length){
            if(arr[row][col] <= k){
                c+=row+1;
                col++;
            }else{
                row--;
            }
        }
        return c;
    }
}