class Solution {
    private static final int MOD = 1000000007;
    public int sumDistance(int[] nums, String s, int d) {
         int n = nums.length;
        long[] positions = new long[n];

        // Simulate the movement of the robots for d seconds
        for (int i = 0; i < n; i++) {
            positions[i] = (long) nums[i] + (s.charAt(i) == 'R' ? d : -d);
        }

        // Sort the positions to make the distance calculation easier
        Arrays.sort(positions);

        // Calculate the sum of distances using prefix sums
        long totalDistance = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            // Total distance is sum of absolute differences
            totalDistance = (totalDistance + (positions[i] * i - prefixSum)) % MOD;
            prefixSum = (prefixSum + positions[i]) % MOD;
        }

        return (int) totalDistance;
    }
}