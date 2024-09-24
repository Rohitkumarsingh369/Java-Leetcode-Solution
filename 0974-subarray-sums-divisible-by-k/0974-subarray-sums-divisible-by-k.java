class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       // HashMap to store the frequency of prefix sum remainders
        HashMap<Integer, Integer> remainderFrequency = new HashMap<>();
        
        // Initial case: remainder 0 has occurred once (to count subarrays starting from the beginning)
        remainderFrequency.put(0, 1);
        
        int prefixSum = 0;
        int count = 0;
        
        // Traverse through the array
        for (int num : nums) {
            // Calculate the current prefix sum
            prefixSum += num;
            
            // Calculate the remainder of the current prefix sum with k
            int remainder = prefixSum % k;
            
            // If the remainder is negative, convert it to a positive equivalent in the range [0, k-1]
            if (remainder < 0) {
                remainder += k;
            }
            
            // Check how many times this remainder has occurred before
            if (remainderFrequency.containsKey(remainder)) {
                count += remainderFrequency.get(remainder);
            }
            
            // Update the frequency of this remainder
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}