class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] tailIndex = new int[nums.length];
        tailIndex[0] = nums[0];
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tailIndex[len - 1]) {
                tailIndex[len++] = nums[i];
            } else {
                int pos = binarySearch(tailIndex, 0, len - 1, nums[i]);
                tailIndex[pos] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
