class Solution {
    public int splitArray(int[] nums, int K) {
       int[] s = new int[nums.length];
        s[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s[i] = nums[i] + s[i - 1];
        }
        
        for (int k = 2; k <= K; k++) {
            for (int i = nums.length - 1; i >= k - 1; i--) {
                int min = Integer.MAX_VALUE;
                int left = nums[i];
                for (int p = i - 1; p >= k - 2; p--) {
                    min = Math.min(min, Math.max(s[p], left));
                    left += nums[p];
                    if (left >= min) {
                        break;
                    }
                }
                s[i] = min;
            }
        }
        
        return s[nums.length - 1];
    }
}