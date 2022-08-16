class Solution {
    public char repeatedCharacter(String s) {
        char count[]=new char[256];
        
         int index=-1;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
            if(count[s.charAt(i)]==2){
                index=i;
                break;
            }
        }
        
       
       
        return s.charAt(index);
    }
}