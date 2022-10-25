class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         if(word1.length == 0 || word2.length == 0) return false;
        return String.join("", word1).equals(String.join("", word2));
    }
}