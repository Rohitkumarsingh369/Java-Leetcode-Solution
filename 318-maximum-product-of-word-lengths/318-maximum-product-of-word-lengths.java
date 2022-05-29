class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            int[] letters = new int[26];
            for (char c : words[i].toCharArray()) {
                letters[c - 'a'] ++;
            }
            for (int j = 0; j < words.length; j++) {
                if (j == i) continue;
                int k = 0;
                for (; k < words[j].length(); k++) {
                    if (letters[words[j].charAt(k) - 'a'] != 0) {
                        break;
                    }
                }
                if (k == words[j].length()) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}