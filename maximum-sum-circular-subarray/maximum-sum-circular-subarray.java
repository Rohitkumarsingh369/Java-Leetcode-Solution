class Solution {
    public int maxSubarraySumCircular(int[] a) {
        
        int n=a.length;
        // Corner Case
    if (n == 1)
      return a[0];
 
    // Initialize sum variable which store total sum of
    // the array.
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }
 
    // Initialize every variable with first value of
    // array.
    int curr_max = a[0], max_so_far = a[0],
    curr_min = a[0], min_so_far = a[0];
 
    // Concept of Kadane's Algorithm
    for (int i = 1; i < n; i++)
    {
 
      // Kadane's Algorithm to find Maximum subarray
      // sum.
      curr_max = Math.max(curr_max + a[i], a[i]);
      max_so_far = Math.max(max_so_far, curr_max);
 
      // Kadane's Algorithm to find Minimum subarray
      // sum.
      curr_min = Math.min(curr_min + a[i], a[i]);
      min_so_far = Math.min(min_so_far, curr_min);
    }
    if (min_so_far == sum) {
      return max_so_far;
    }
 
    // returning the maximum value
    return Math.max(max_so_far, sum - min_so_far);
    }
}