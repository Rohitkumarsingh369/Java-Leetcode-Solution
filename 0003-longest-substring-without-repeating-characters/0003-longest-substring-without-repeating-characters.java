class Solution {
    public int lengthOfLongestSubstring(String s) {
//          HashSet<Character> set = new HashSet<>();
//         int left = 0, right = 0;
//         int maxLength = 0;
        
//         while (right < s.length()) {
//             if (!set.contains(s.charAt(right))) {
//                 set.add(s.charAt(right));
//                 maxLength = Math.max(maxLength, right - left + 1);
//                 right++;
//             } else {
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//         }
        
//         return maxLength;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int start = 0; // To store the start index of the longest substring

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }
            map.put(currentChar, right);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left; // Update start index when a longer substring is found
            }
        }

        // Extract the longest substring
        // String longestSubstring = s.substring(start, start + maxLength);
        // return longestSubstring;
        return maxLength;
    }
}