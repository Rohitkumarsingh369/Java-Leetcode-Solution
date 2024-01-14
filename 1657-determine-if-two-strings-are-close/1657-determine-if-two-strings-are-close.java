class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        if(word1.equals(word2))
            return true;
        
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        
        for(int i=0;i<word1.length();i++){
            char c1=word1.charAt(i);
            freq1[c1-'a']++;
            
            char c2=word2.charAt(i);
            freq2[c2-'a']++;
        }
        
       
        
        
        for(int i=0;i<26;i++){
            if((freq1[i]==0 && freq2[i]!=0) ||(freq1[i]!=0 && freq2[i]==0))
                return false;
        }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        return Arrays.equals(freq1,freq2);

       // return true;
        
        
    }
}