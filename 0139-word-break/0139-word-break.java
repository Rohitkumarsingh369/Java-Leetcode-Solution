class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         // Create a set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create a DP array, dp[i] indicates if s[0:i] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string can always be segmented
        
        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0:j] can be segmented and s[j:i] is in wordDict, set dp[i] to true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if dp[i] is already true
                }
            }
        }
        
        // Return the result for the full string
        return dp[s.length()];
    }
}