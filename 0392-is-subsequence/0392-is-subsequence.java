class Solution {
    public boolean isSubsequence(String s, String t) {
         int m = s.length();
        int n = t.length();

        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        // Traverse both strings
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move the pointer in s if there's a match
            }
            j++; // Always move the pointer in t
        }

        // If i has reached the end of s, it means all characters of s were found in t in the correct order
        return i == m;
    }
}