class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Step 1: Separate positive and negative numbers
        int n = nums.length;
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];
        
        int posIndex = 0, negIndex = 0;
        
        for (int num : nums) {
            if (num > 0) {
                pos[posIndex++] = num;
            } else {
                neg[negIndex++] = num;
            }
        }
        
        // Step 2: Interleave positive and negative numbers
        int[] result = new int[n];
        int index = 0;
        
        for (int i = 0; i < n / 2; i++) {
            result[index++] = pos[i];
            result[index++] = neg[i];
        }
        
        return result;
    }
}