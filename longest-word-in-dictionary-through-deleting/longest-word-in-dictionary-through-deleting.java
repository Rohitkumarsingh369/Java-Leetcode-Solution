class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String result="";
        int length=0;
        
        for(String word:dictionary){
            if(length<word.length() && checksubsequence(word,s)||length==word.length() && result.compareTo(word)>0 && checksubsequence(word,s)){
                length=word.length();
                result=word;
            }
        }
        return result;
    }
    public boolean checksubsequence(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        
        int j=0;
        
        for(int i=0;i<len2 && j<len1;i++){
            if(str1.charAt(j)==str2.charAt(i))
                j++;
        }
        return (j==len1);
    }
}