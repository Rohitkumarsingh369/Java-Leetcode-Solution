class Solution {
    public String minWindow(String s, String t) {
      // Edge case: if t is longer than s, it's impossible to find a window
        if (s.length() < t.length()) {
            return "";
        }

        // Step 1: Count the characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Initialize sliding window variables
        int left = 0, right = 0;
        int minLeft = 0, minLength = Integer.MAX_VALUE;
        int required = tCount.size();  // Number of unique characters in t that need to be matched
        int formed = 0;  // Tracks how many unique characters are fully matched in the window
        Map<Character, Integer> windowCount = new HashMap<>();  // Window character count

        // Step 3: Expand the window by moving the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // If the character in the window matches the count in t, increase 'formed'
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // Step 4: Contract the window by moving the left pointer
            while (left <= right && formed == required) {
                char startChar = s.charAt(left);

                // Update the result if this window is smaller
                if (right - left + 1 < minLength) {
                    minLeft = left;
                    minLength = right - left + 1;
                }

                // Remove the character at the left pointer from the window
                windowCount.put(startChar, windowCount.get(startChar) - 1);

                // If removing the left character makes the window invalid, decrease 'formed'
                if (tCount.containsKey(startChar) && windowCount.get(startChar).intValue() < tCount.get(startChar).intValue()) {
                    formed--;
                }

                // Move the left pointer to contract the window
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        // Step 5: Return the result
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
  
    
}