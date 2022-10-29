class Solution {
    public int earliestFullBloom(int[] pt, int[] gt) {
        // sort by growtime
        int n  = pt.length;
        
        int arr[] = new int [100001];
        
        for(int i=0; i<n; i++){
            arr[gt[i]] += pt[i];
        }
        
        int curr =0, ans = 0;
        
        for(int i=arr.length-1; i>=1; i--){
            
            if (arr[i]==0) continue;
            
            curr += arr[i];
            
            ans = Math.max(ans, curr+i);
        }
        
        return ans;
    }
}