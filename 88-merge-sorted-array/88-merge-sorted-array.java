class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        for(int i=0;i<m && n>0;i++){
            if(arr1[i]>arr2[0] ){
                int temp=arr1[i];
                arr1[i]=arr2[0];
                arr2[0]=temp;
                
                int k,first=arr2[0];
                
                for(k=1;k<n && arr2[k]<first;k++){
                    arr2[k-1]=arr2[k];
                }
                arr2[k-1]=first;
            }
        }
        int index=0;
        for(int i=m;i<m+n;i++)
            arr1[i]=arr2[index++];
    }
}