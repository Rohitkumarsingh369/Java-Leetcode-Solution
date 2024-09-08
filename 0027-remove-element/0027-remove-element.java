class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;  // Pointer to track the position for the next element that is not equal to val

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];  // Assign current element to the position tracked by i
                i++;  // Move the pointer i
            }
        }

        return i;
    }
}