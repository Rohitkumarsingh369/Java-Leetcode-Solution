class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        int res=0;
        int left=0;
        int right=nums.length-1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                res=nums[i]^nums[j];
                max=Math.max(max,res);
                
            }
        }
        
        return max;
    }
}