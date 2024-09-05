class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26]; // Assuming input is lowercase English letters
        
        // Count frequencies of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1; // If no unique character is found
    }
}