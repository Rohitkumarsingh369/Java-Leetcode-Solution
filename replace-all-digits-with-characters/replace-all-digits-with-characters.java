class Solution {
    public String replaceDigits(String s) {
        char c[]=s.toCharArray();
       for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])){
                c[i]=(char)((int)c[i-1]+(c[i]-'0'));
            }
       }
        return new String(c);
    }
}