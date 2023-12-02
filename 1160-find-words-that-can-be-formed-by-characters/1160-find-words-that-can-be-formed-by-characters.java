class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        int len = 0;
        for(String word: words){
            Arrays.fill(map,0);
            for(char c: chars.toCharArray()){
                ++map[c - 'a'];
            }
            boolean found = true;
            for(char c: word.toCharArray()){
                if(map[c - 'a'] == 0){
                    found = false;
                    break;
                }
                --map[c - 'a'];
            }
            if(found){
                len += word.length();
            }
        }
        return len;
    }
}