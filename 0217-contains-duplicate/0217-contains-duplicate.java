class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Step 1: Create a HashSet to track unique elements
        HashSet<Integer> set = new HashSet<>();
        
        // Step 2: Iterate over the array
        for (int num : nums) {
            // Step 3: Check if the number is already in the set
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            // Step 4: Add the number to the set if it's not already present
            set.add(num);
        }
        
        // Step 5: If no duplicates were found, return false
        return false;
    }
}