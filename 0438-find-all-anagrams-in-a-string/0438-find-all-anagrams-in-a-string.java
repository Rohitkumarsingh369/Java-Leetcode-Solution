class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();
        
        int[] pCount = new int[26]; // Frequency count for string p
        int[] sCount = new int[26]; // Frequency count for the current window in s
        
        // Fill pCount with the frequencies of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        int pLength = p.length();
        
        // Traverse through s with a sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the sCount
            sCount[s.charAt(i) - 'a']++;
            
            // Remove the character that is left behind in the sliding window
            if (i >= pLength) {
                sCount[s.charAt(i - pLength) - 'a']--;
            }
            
            // Compare the two counts
            if (i >= pLength - 1 && compareCounts(pCount, sCount)) {
                result.add(i - pLength + 1); // Start index of the anagram
            }
        }
        
        return result;
    }
    private boolean compareCounts(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}