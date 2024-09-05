class Solution {
    public int findLHS(int[] nums) {
         // if the array size is 0 or 1 than return 0
        if(nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        // using two pointer two record two index
        int leftPtr = 0;
        int rightPtr = 1;
        int result = 0;
        while(rightPtr < nums.length && leftPtr < nums.length ) {
            // if maximum value and its minimum value is exactly 1, then we calculate the length and rightPtr + 1
            if(nums[rightPtr] - nums[leftPtr] == 1) {
                result = Math.max(result, rightPtr - leftPtr + 1);
                rightPtr++;
            }
            else {
                // if left and right pointer are not the same value leftPtr + 1, otherwise rightPtr + 1
                if(nums[rightPtr] != nums[leftPtr]) {
                    leftPtr++;
                }
                else {
                    rightPtr++;
                }
            }
        }
        return result;
    }
}