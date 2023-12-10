class Solution {   
       /* public int extend(String s, int start, int end){
            if(start >= 0 && end < s.length()){
                if (s.charAt(start) == s.charAt(end)){
                    return 2 + extend(s, start - 1, end + 1);
                }
            }
            return 0;
        }      
        
        public String longestPalindrome(String s) {
            int res = 0;
            int temp = 0; 
            int mid = 0;
            for(int i = 0; i < s.length(); i++){
                temp = 1 + extend(s, i - 1, i + 1);
                temp = Math.max(temp, extend(s, i, i + 1));
                if(res < temp){
                    res = Math.max(temp, res);
                    mid = i;
                }
            }
            //System.out.println(mid);
            if(res % 2 == 0) return (s.substring(mid + 1 - res/2, mid + 1 + res/2));
            return s.substring(mid - res/2 , mid + res/2 + 1);
            
        }*/
    public String longestPalindrome(String s) {
        int maxLen = 1;
        String res = s.substring(0,1);
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for(int start = n-1; start >= 0; start--){
            for(int end = start + 1; end < n; end++){
                if(s.charAt(start) == s.charAt(end)){
                    if(dp[start + 1][end - 1] || end == start + 1){
                        dp[start][end] = true;
                        if(maxLen < end - start + 1){
                            maxLen = end - start + 1;
                            res = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }
        return res;
    }
}