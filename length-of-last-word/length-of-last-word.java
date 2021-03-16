class Solution {
    public int lengthOfLastWord(String s) {
        int len=s.length();
        char c;
        if(len>0){
            s=s.trim();
            int count=0;
           for(int i=s.length()-1;i>=0;i--){
               c=s.charAt(i);
               if(c!=' ')
                    count++;
               else
                    break;
           }
            return count;
        }
        
        return 0;
    }
}