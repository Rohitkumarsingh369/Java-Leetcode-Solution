class Solution {
    public int firstUniqChar(String s) {
        char count[]=new char[256];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        
        int index=-1;
        int i;
        for(i=0;i<s.length();i++){
            if(count[s.charAt(i)]==1){
                index=i;
                break;
            }
        }
        return index;
    }
}