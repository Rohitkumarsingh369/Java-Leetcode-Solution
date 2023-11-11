class Solution {
    public boolean isAnagram(String a, String b) {
      /* int count[]=new int[256];
        
        if(a.length()!=b.length())
         return false;
        
         for(int i=0;i<a.length();i++){
             count[a.charAt(i)-'a']++;
             count[b.charAt(i)-'a']--;
         }
         
         
         
         
         for(int i=0;i<count.length;i++){
             if(count[i]!=0)
                return false;
         }
         
         return true;*/
        
        int count[]=new int[256];
        
        if(a.length()!=b.length()){
            return false;
        }
        
        for(int i=0;i<a.length();i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        
        for(int i=0;i<256;i++){
            if(count[i]!=0){
                return false;
            }
        }
        
        return true;
    }
}