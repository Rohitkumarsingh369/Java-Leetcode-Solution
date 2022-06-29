class Solution {
    public int[] rearrangeArray(int[] nums) {
         int[] ans = new int[nums.length];
    int i =0;
    int j = 0;
    while(i<nums.length){
        if(nums[i]>0){
            ans[j] = nums[i];
            j+=2;
        }
        i++;
    }
    i = 0;
    j = 1;
    while(i<nums.length){
        if(nums[i]<0){
            ans[j] = nums[i];
            j+=2;
        }
        i++;
    }
    return ans;
    }
}