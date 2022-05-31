class Solution {
    public boolean hasAllCodes(String s, int k) {
       /* int len = S.length(), count = 1 << K;
        if (K > len) return false;
        int num = K > 1 ? Integer.parseInt(S.substring(len - K + 1), 2) << 1 : 0;
        boolean[] seen = new boolean[count];
        for (int i = len - K; i >= 0; i--) {
            num = (((S.charAt(i) - '0') << K) + num) >> 1;
            if (!seen[num]) {
                seen[num] = true;
                count--;
            }
            if (count == 0) return true;
            if (i < count) return false;
        }
        return false;*/
        // Unordered map of type string
        Set<String> us= new HashSet<String>();
        for(int i = 0; i + k <= s.length(); i++)
        {
            us.add(s.substring(i, i + k));
        }
        return (us.size() == (1 << k));
    }
}