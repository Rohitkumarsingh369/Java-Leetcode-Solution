class Solution {
    
    //test case ()(()
    //make the program based on this
    public int longestValidParentheses(String s) {
        int open=0;
        int close=0;
        int maxLen=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(c=='(') open++;
            else close++;
            
            if(open==close){
                maxLen=Math.max(maxLen,open+close);
            }
            else if(close>open){
                open=close=0;
            }
        }
        
        open=close=0;
        
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            
            if(c=='(') open++;
            else close++;
            
            if(open==close){
                maxLen=Math.max(maxLen,open+close);
            }
            else if(close<open){
                open=close=0;
            }
        }
        return maxLen;
    }
}