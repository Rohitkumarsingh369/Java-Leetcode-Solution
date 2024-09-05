class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       // Step 1: Create a map to store the latest index of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 2: Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            
            // Step 3: Check if the element already exists in the map
            if (map.containsKey(currentElement)) {
                // Step 4: Check the difference in indices
                if (i - map.get(currentElement) <= k) {
                    return true; // Found a duplicate within the allowed range
                }
            }
            
            // Step 5: Update the map with the current index of the element
            map.put(currentElement, i);
        }
        
        // Step 6: If no duplicate found within range k, return false
        return false; 
    }
}