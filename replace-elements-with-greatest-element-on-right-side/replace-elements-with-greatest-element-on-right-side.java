class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int j=i+1;
            int max=0;
            while(j<arr.length){
                max=Math.max(max,arr[j]);
                j++;
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}