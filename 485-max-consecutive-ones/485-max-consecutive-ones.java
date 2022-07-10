class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i,max=-1,c=0,n=nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]==0)
                c=0;
            else
                c++;
            max=Math.max(max,c);
        }
        return max;
    }
}