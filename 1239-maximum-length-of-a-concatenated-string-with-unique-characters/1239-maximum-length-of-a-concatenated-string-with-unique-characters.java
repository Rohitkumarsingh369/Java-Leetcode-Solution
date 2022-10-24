class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[] masks = new int[n];
        
        for (int i = 0; i < n; i++) {
            masks[i] = getMask(arr.get(i));
        }
        
        int status = 0;
        
        return check(masks, 0, status);
    }
    
    private int check(int[] masks, int i, int status) {
        if (i == masks.length) {
            return getLength(status);
        }
        
        int result = check(masks, i + 1, status);
        
        if ((masks[i] & status) == 0) {
            int tempResult = check(masks, i + 1, status | masks[i]);
            result = Math.max(result, tempResult);
        }
        
        return result;
    }
    
    private int getLength(int status) {
        if (status < 0) return 0;
        
        int result = 0;
        
        while (status != 0) {
            result += status & 1;
            status >>= 1;
        }
        
        return result;
    }
    
    private int getMask(String s) {
        int result = 0;
        
        for (char c : s.toCharArray()) {
            int mask = 1 << (c - 'a');
            
            if ((mask & result) != 0) {
                return -1;
            }
            
            result |= mask;
        }
        
        return result;
    }
}