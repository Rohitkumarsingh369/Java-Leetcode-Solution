class Solution {
    String str1, str2;
    int n;
    int[][][] dp;
    public boolean isScramble(String s1, String s2) {
        str1 = s1;
        str2 = s2;
        n = s1.length();
        
        dp = new int[n][][];
        
        for (int i = 0; i < n; ++i) {
            dp[i] = new int[n][];
            
            for (int j = 0; j < n; ++j) {
                dp[i][j] = new int[n+1];
                
                for (int k = 0; k <= n; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }
        if (s2.length() != n) return false;
        
        return isScramble(0, 0, n);
    }
    
    boolean isScramble(int l1, int l2, int count) {
        if (count == 0) return true;
        
        if (count == 1) return (str1.charAt(l1) == str2.charAt(l2));
        
        if (dp[l1][l2][count] != -1) {
            return (dp[l1][l2][count] == 1);
        }
        boolean answer = false;
        for (int i = 1; i < count; ++i) {
            if((isScramble(l1, l2, i) && isScramble(l1+i, l2+i, count-i)) || (isScramble(l1, l2+count-i, i) && isScramble(l1+i, l2, count-i))) {
                dp[l1][l2][count] = 1;
                return true;
            }
        }
        
        dp[l1][l2][count] = 0;
        
        return false;
    }
}