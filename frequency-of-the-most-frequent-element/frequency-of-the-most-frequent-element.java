class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=0;
        int i=0 , result=0;
        
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            long allmax=nums[j]*(j-i+1); 
            
            if(sum+k<allmax){  
                sum-=nums[i];
                i++;
            }
            result=Math.max(result,j-i+1);
        }
        return result;
    }
}