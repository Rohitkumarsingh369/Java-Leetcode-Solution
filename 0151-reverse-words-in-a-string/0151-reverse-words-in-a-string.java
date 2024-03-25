class Solution {
    public String reverseWords(String s) {
       /* s=s.trim();
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
        return result.trim();*/
        
        
        
       /* StringBuilder result = new StringBuilder();
        int wordEnd = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                wordEnd = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (result.length() != 0) {
                    result.append(' ');
                }
                result.append(s, i, wordEnd);
            }
        }
        return result.toString();*/
        
        String result = "";
        int wordEnd = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                wordEnd = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                result += (result.isEmpty() ? "" : " ") + s.substring(i, wordEnd);
            }
        }
        return result;
    }
}