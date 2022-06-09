class Solution {
    public int removePalindromeSub(String s) {
       
        if(s.isBlank())
            return 0;
            
        if(ispalin(s))
            return 1;
        
        return 2;
    }
    
    public boolean ispalin(String s){
        int left=0;
        int right=s.length()-1;
        
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}