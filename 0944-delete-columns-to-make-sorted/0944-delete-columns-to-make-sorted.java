class Solution {
     public int minDeletionSize(String[] strs) {
        if(strs == null || strs.length == 0) return 0;
        int deletions = 0;
        for(int column = 0; column < strs[0].length(); column++){
            char character = strs[0].charAt(column);
            for(int word = 0; word < strs.length; word++){
                if(strs[word].charAt(column) < character){
                    deletions++;
                    break;
                }
                character = strs[word].charAt(column);
            }
        }

        return deletions;
    }
}