class Solution {
    public int findLongestChain(int[][] pairs) {
         // Step 1: Sort pairs based on the second element of each pair
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int currentEnd = Integer.MIN_VALUE; // To store the end of the current valid pair
        int count = 0; // To count the number of pairs in the chain

        // Step 2: Iterate over the pairs
        for (int[] pair : pairs) {
            // Step 3: If the start of the current pair is greater than the end of the previous valid pair
            if (pair[0] > currentEnd) {
                count++; // We can include this pair in the chain
                currentEnd = pair[1]; // Update the end to the current pair's end
            }
        }

        return count; // Return the maximum length of the chain
    }
}