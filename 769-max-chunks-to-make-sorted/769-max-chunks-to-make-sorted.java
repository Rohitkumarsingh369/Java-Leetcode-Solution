class Solution {
    public int maxChunksToSorted(int[] arr) {
        int temp=arr[0];
        int count=1;
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]>temp && i<=temp){
                temp = arr[i];
            }
            else if(temp<i){
                temp = arr[i];
                count++;
            }
        }
        return count;
    }
}