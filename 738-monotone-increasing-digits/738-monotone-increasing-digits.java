class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        
        int marker=arr.length;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                marker=i;
                arr[i-1]--;
            }
        }
        
        for(int i=marker;i<arr.length;i++){
            arr[i]='9';
        }
        
        return Integer.parseInt(String.valueOf(arr));
    }
}