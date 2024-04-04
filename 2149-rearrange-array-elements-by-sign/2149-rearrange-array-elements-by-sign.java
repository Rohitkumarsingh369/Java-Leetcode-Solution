class Solution {
    public int[] rearrangeArray(int[] a) {
        int n=a.length;
        int result[]=new int[n];
        int pos=0,neg=1;
        for(int i=0;i<n;i++){
            if(a[i]>0){
                result[pos]=a[i];
                pos=pos+2;
            }
            else{
                result[neg]=a[i];
                neg=neg+2;
            }
        }
        return result;
    }
}