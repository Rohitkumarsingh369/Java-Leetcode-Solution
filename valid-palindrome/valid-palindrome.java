class Solution {
    public boolean isPalindrome(String s) {
        s=s.trim();
        s=s.toLowerCase();
        int len=s.length();
        String word="";
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c>='a'&& c<='z'||c>='A'&& c<='Z'||c>='0'&&c<='9')
                word=word+c;
        }
        StringBuffer sb=new StringBuffer(word);  
        //System.out.println(word);
        String revword=sb.reverse().toString();
        //System.out.println(sb.reverse().toString());
        
            if(word.equals(revword))
            return true;
    
        return false;
    }
}