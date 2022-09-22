class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s+" ";
        
        String str="",word="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(c!=' ')
            {
                str=c+str;
                
            }
            else{
                word=word+str+" ";
                str="";
            }
        }
       // System.out.println(word);
        return word.trim();
    }
}