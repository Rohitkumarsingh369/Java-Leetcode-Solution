class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxSum = kadane(A); // Maximum sum for non-circular subarray
        int totalSum = 0;
        int minSum = kadaneMin(A); // Minimum sum for subarray
        
        // Calculate total sum of the array
        for (int num : A) {
            totalSum += num;
        }
        
        // Handle the edge case where all elements are negative
        if (totalSum == minSum) {
            return maxSum;
        }
        
        // Calculate circular subarray sum and return the maximum
        return Math.max(maxSum, totalSum - minSum);
    }
    
    // Kadane's algorithm to find maximum subarray sum
    private int kadane(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int num : A) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Kadane's algorithm to find minimum subarray sum
    private int kadaneMin(int[] A) {
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        
        for (int num : A) {
            currentSum = Math.min(num, currentSum + num);
            minSum = Math.min(minSum, currentSum);
        }
        
        return minSum;
    }
}
