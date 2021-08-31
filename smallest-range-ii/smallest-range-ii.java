class Solution {
    public int smallestRangeII(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int small=arr[0]+k;
        int large=arr[n-1]-k;
        
        int ans=arr[n-1]-arr[0];
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        
        for(int i=0;i<n-1;i++){
            min=Math.min(small,arr[i+1]-k);
            max=Math.max(large,arr[i]+k);
            
            /*if(min<0)
                continue;*/
            ans=Math.min(ans,max-min);
        }
        return ans;
    }
}