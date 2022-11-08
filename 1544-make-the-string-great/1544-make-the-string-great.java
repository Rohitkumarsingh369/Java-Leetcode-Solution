class Solution {
    public String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
        //Now we check if the either the present or the next character is capital
        if (Math.abs(s.charAt(i) - s.charAt(i+1)) == 32) {  
            //recursive call for the rest of the string 
            return makeGood(s.substring(0, i) + s.substring(i+2));
        }
    }     
    return s;
    }
}