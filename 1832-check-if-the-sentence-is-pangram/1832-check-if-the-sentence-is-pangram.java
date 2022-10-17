class Solution {
    public boolean checkIfPangram(String s) {
        
        boolean count[]=new boolean[26];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']=true;
        }
        
        for(int i=0;i<26;i++){
            if(count[i]==false){
                return false;
            }
        }
        
        return true;
    }
}