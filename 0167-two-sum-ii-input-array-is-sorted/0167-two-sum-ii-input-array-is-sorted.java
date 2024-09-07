class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int left = 0; // Pointer at the beginning of the array
        int right = numbers.length - 1; // Pointer at the end of the array

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return the 1-indexed positions
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }

        // If no solution is found, return an empty array
        return new int[] {-1, -1};  
    }
}