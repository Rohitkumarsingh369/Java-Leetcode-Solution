class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String w : dictionary){
            set.add(w);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);

        return helper(set,dp,s,0);
    }

    public int helper(Set<String> set,int[] dp,String s,int idx){
        if(idx>=s.length()) return 0;
        if(dp[idx] !=-1) return dp[idx];
        //current char is not part of any word in dictionary
        int absent = 1 + helper(set,dp,s,idx+1);
        //current char is part of any word in dictionary
        int present = Integer.MAX_VALUE;
        for(int i = idx; i < s.length(); i++){
            if(set.contains(s.substring(idx, i + 1))){
                present = Math.min(present, helper(set, dp, s, i + 1));
            }
        }
        return dp[idx]=Math.min(absent,present);
    }
}