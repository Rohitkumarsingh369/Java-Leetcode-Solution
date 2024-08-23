class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);  // Find first position
        result[1] = binarySearch(nums, target, false); // Find last position
        return result;
    }
    private static int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                position = mid; // potential result
                if (findFirst) {
                    right = mid - 1; // Search in the left half for the first position
                } else {
                    left = mid + 1; // Search in the right half for the last position
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return position;
    }
}