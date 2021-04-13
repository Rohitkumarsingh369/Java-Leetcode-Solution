class Solution {
    public int[] constructArray(int n, int k) {
        int result[]=new int[n];
        int high=n,low=1;
        int index=0;
        result[index++]=low++;
        boolean ishigh=false;
        while(k>1){
            result[index++]=high--;
            k--;
            ishigh=true;
            if(k>1){
                result[index++]=low++;
                k--;
                ishigh=false;
            }
        }
        //increasing pr decreasing order
        while(index<n){
            if(ishigh)
                result[index++]=high--;
            else
                result[index++]=low++;
        }
        return result;
    }
}