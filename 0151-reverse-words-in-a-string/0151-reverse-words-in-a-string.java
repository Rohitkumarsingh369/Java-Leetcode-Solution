class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s+" ";
        String word="",result="";
        for(int i=0;i<s.length();i++){
            if(i!=s.length()-1&&s.charAt(i+1)==' '&&s.charAt(i)==' ')
                continue;
            if(s.charAt(i)!=' ')
                word=word+s.charAt(i);
            
            else{
                result=word+" "+result;
                word="";
            }
            
        }
        return result.trim();
    }
}