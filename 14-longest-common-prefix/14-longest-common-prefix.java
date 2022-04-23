class Solution {
    public String longestCommonPrefix(String[] str) {
         if(str.length == 0) return "";
        
        String s = str[0];
        
        for(int i = 1; i<str.length; i++)
            while(str[i].indexOf(s) != 0){
                s = s.substring(0,s.length()-1);
            }
       
        
        return s;
    }
}