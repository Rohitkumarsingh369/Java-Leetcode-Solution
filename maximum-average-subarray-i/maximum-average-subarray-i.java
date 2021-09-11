class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len=nums.length;
        
        int max=0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        int temp=max;
        
        for(int i=k;i<len;i++){
            temp+=nums[i]-nums[i-k];
            max=Math.max(max,temp);
        }
        
        double result=(max*1.0)/k;
        return result;
    }
}