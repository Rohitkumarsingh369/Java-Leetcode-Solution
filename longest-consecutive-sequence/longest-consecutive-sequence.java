class Solution {
    HashSet<Integer> seen;
    HashMap<Integer, Integer> memo;
    public int longestConsecutive(int[] nums) {
        seen = new HashSet<>();
        for (int x : nums) seen.add(x);

        memo = new HashMap<>();
        int ans = 0;
        for (int x : nums)
            ans = Math.max(ans, dp(x));
        return ans;
    }
    int dp(int x) {
        if (memo.containsKey(x)) return memo.get(x);
        int ans = 1;
        if (seen.contains(x-1))
            ans += dp(x-1);
        memo.put(x, ans);
        return ans;
    }
}