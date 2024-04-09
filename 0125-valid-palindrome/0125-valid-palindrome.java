class Solution {
  /*  public boolean isPalindrome(String s) {
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
    }*/
    /* public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int j=1;
        
        for (int i = 0; i<s.length(); i++){

            if (s.charAt(i) != s.charAt(s.length()-j++)){

                return false;
            }

        }
        return true;*/
    public static boolean isPalindrome(String s) {
    if (s.isEmpty()) {
         return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
         cHead = s.charAt(head);
         cTail = s.charAt(tail);
         if (!Character.isLetterOrDigit(cHead)) {
          head++;
         } else if(!Character.isLetterOrDigit(cTail)) {
          tail--;
         } else {
          if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
           return false;
          }
          head++;
          tail--;
         }
        }
        
        return true;
    }
}