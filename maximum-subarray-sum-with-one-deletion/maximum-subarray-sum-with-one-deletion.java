class Solution {
    public int maximumSum(int[] arr) {
        
        int n=arr.length;
        int fw[]=new int[n];
        int bw[]=new int[n];
        
        int curmax=arr[0],maxsofar=arr[0];
        
        fw[0]=arr[0];
        for(int i=1;i<n;i++){
            curmax=Math.max(arr[i],curmax+arr[i]);
            
            maxsofar=Math.max(maxsofar,curmax);
            
            fw[i]=curmax;
        }
        
         curmax=maxsofar=bw[n-1]=arr[n-1];
        
        for(int i=n-2;i>=0;i--){
            curmax=Math.max(arr[i],curmax+arr[i]);
            
            maxsofar=Math.max(maxsofar,curmax);
            
            bw[i]=curmax;
        }
        
        int result=maxsofar;
        
        for(int i=1;i<n-1;i++){
           result=Math.max(result,fw[i-1]+bw[i+1]);
        }
        
        return result;
    }
}