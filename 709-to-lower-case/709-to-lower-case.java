class Solution {
    public String toLowerCase(String s) {
        
        char lower[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                lower[i]=(char)((int)s.charAt(i)+32);
            }
        }
        return new String(lower);
    }
}