class Solution {
    public int numJewelsInStones(String jewels, String stones) {
         return stones.replaceAll("[^" + jewels + "]", "").length();
    }
}