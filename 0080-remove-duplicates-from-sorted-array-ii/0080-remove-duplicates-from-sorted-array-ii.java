class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // If the array length is less than or equal to 2, return it as is.

        int i = 2;  // Start the pointer at index 2 because the first two elements can always stay.

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;  // i now represents the length of the modified array.
    }
}