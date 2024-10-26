class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;

        int maxLength = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Move left pointer down the mountain
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Move right pointer down the mountain
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the current mountain
                int currentLength = right - left + 1;
                maxLength = Math.max(maxLength, currentLength);

                // Move the index to the end of the current mountain
                i = right;
            }
        }

        return maxLength;
    }
}