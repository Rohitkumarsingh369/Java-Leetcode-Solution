class Solution {
    public String kthLargestNumber(String[] nums, int k) {
         // Create a min-heap (priority queue)
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            // Compare based on the length of the strings
            if (a.length() != b.length()) {
                return a.length() - b.length(); // Smaller length first
            }
            // If the lengths are equal, compare lexicographically
            return a.compareTo(b); // Lexicographically smaller first
        });

        // Process each number in the nums array
        for (String num : nums) {
            // Add the current number to the heap
            minHeap.offer(num);

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}