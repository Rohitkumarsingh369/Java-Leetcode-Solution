class Solution {
    public int singleNonDuplicate(int[] nums) {
//         int low = 0, high = nums.length - 1;

//         while (low < high) {
//             int mid = low + (high - low) / 2;

//             // Ensure mid is even to check pairs correctly
//             if (mid % 2 == 1) {
//                 mid--; // Move mid to the start of the pair
//             }

//             // Compare mid and mid + 1
//             if (nums[mid] == nums[mid + 1]) {
//                 // Single element is in the right half
//                 low = mid + 2;
//             } else {
//                 // Single element is in the left half
//                 high = mid;
//             }
//         }

//         // low will eventually point to the single element
//         return nums[low];
        
        
         int low = 0, high = nums.length - 1;

        while (low <= high) { // Standard binary search condition
            int mid = low + (high - low) / 2;

            // Check if nums[mid] is the single element
            if ((mid == 0 || nums[mid] != nums[mid - 1]) 
                && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            // Determine the search space
            if (mid % 2 == 0) { // Mid is even
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2; // Search right half
                } else {
                    high = mid - 1; // Search left half
                }
            } else { // Mid is odd
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1; // Search right half
                } else {
                    high = mid - 2; // Search left half
                }
            }
        }

        // This point is reached when the single element is found
        return nums[low]; // low points to the single element
    }
}