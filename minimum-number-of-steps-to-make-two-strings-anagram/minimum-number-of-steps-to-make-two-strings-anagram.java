class Solution {
    public int minSteps(String word1, String word2) {
        if(word1.equals(word2))
            return 0;
        
        int count[]=new int[26];
        int result=0;
        for(int i=0;i<word1.length();i++){
            count[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++){
            if(count[word2.charAt(i)-'a']>0)
                count[word2.charAt(i)-'a']--;
            else result++;
        }
        
        
        
        return result;
    }
}