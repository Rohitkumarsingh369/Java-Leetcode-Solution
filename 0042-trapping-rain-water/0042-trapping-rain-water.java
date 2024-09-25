class Solution {
     public int trap(int[] height) {
         if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // If the left bar is smaller, we deal with left pointer
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update left max
                } else {
                    totalWater += leftMax - height[left];  // Water trapped at left
                }
                left++;
            } else {
                // If the right bar is smaller or equal, we deal with right pointer
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update right max
                } else {
                    totalWater += rightMax - height[right];  // Water trapped at right
                }
                right--;
            }
        }

        return totalWater;
    }
}