class Solution {
    public int minTimeToType(String word) {
        int result=0;
        char prev='a';
        
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            
            int diff1=Math.abs(prev-curr);
            int diff2=Math.abs(26-diff1);
            
            result+=Math.min(diff1,diff2)+1;
                
                prev=curr;
        }
        return result;
    }
}