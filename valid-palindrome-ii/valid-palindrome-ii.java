class Solution {
    public boolean validPalindrome(String s) {
        return checkpalindrome(s,0,s.length()-1,false);
    }
    public boolean checkpalindrome(String s,int left,int right,boolean deleted){
        while(left<right){
            char sleft=s.charAt(left);
        char sright=s.charAt(right);
        
        if(sleft!=sright){
            if(deleted)
                return false;
            
            return checkpalindrome(s,left+1,right,true)||checkpalindrome(s,left,right-1,true);
        }
        left++;
        right--;
        }
        
        return true;
    }
}