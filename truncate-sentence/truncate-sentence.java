class Solution {
    public String truncateSentence(String s, int k) {
        s=s.trim();
        s=s+" ";
        int len=s.length();
        
        int i,count=0;
        for(i=0;i<len;i++){
            if(s.charAt(i)==' ')
                count++;
            
            if(count==k)
                break;
        }
        
        return s.substring(0,i);
    }
}