class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);
        for(int i=1;i<nums.length; i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j])
                    lis[i] = Math.max(lis[j]+1,lis[i]);
            }
        }
        
        int[] lds = new int[nums.length];
        Arrays.fill(lds,1);
        for(int i=nums.length-2;i>=0; i--) {
            for(int j=nums.length-1;j>i;j--) {
                if(nums[i]>nums[j])
                    lds[i] = Math.max(lds[j]+1,lds[i]);
            }
        }
        
        int res = 0;
        for(int i=1; i<nums.length-1; i++) {
            if(lis[i]>1 && lds[i]>1)
            res = Math.max(res,(lis[i]+lds[i]-1));
        }
        return nums.length-res;
    }
}