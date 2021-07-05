class Solution {
    public int countVowelPermutation(int n) {
        // To avoid the large output value
        int MOD = (int)(1e9 + 7);
 
        // Initialize 2D dp array
        long[][] dp = new long[n + 1][5];
 
        // Initialize dp[1][i] as 1 since
        // string of length 1 will consist
        // of only one vowel in the string
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
 
        // Directed graph using the
        // adjacency matrix
        int[][] relation = new int[][] {
            { 1 }, { 0, 2 },
            { 0, 1, 3, 4 },
            { 2, 4 }, { 0 }
        };
 
        // Iterate over the range [1, N]
        for (int i = 1; i < n; i++) {
 
            // Traverse the directed graph
            for (int u = 0; u < 5; u++) {
                dp[i + 1][u] = 0;
 
                // Traversing the list
                for (int v : relation[u]) {
 
                    // Update dp[i + 1][u]
                    dp[i + 1][u] += dp[i][v] % MOD;
                }
            }
        }
 
        // Stores total count of permutations
        long ans = 0;
 
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
 
        // Return count of permutations
        return (int)ans;
    }
}