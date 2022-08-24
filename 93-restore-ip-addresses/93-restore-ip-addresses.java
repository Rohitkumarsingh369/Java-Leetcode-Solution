class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        
        backtrack(s, "", 0, 0);
        
        return result;
    }
    
    private void backtrack(String s, String currIp, int pos, int dots) {
        if (dots == 4 && pos == s.length()) {
            result.add(currIp.substring(0, currIp.length() - 1));
            return;
        } else if (dots > 4) {
            return;
        }
        
        for (int i = pos; i < Math.min(pos + 3, s.length()); i++) {
            int num = Integer.parseInt(s.substring(pos, i + 1));
            
            if (num < 256 && (pos == i || s.charAt(pos) != '0')) {
                backtrack(s, currIp + num + ".", i + 1, dots + 1);
            }
        }
    }
}