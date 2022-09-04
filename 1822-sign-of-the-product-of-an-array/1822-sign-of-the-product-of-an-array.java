class Solution {
    public int arraySign(int[] nums) {
         int neg = 0;
        
        for (int i=0; i<nums.length; i++) {
            int val = nums[i];
            
            if (val == 0) {
                return 0;
            }
            else if (val < 0) {
                neg += 1;
            }
        }
        
        return neg % 2 == 0 ? 1 : -1;
    }
}