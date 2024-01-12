class Solution {
   /* public boolean halvesAreAlike(String s) {
        return s.substring(0, s.length() / 2).toLowerCase().replaceAll("[aeoui]", "").length()                == s.substring(s.length() / 2).toLowerCase().replaceAll("[aeoui]", "").length();
    }*/
    public boolean isVowel(char c){
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int first = 0;
        int second = 0;
        
        for(int i = 0; i < n / 2; i++){
            if(isVowel(s.charAt(i)) == true){
                first++;
            }
        }
        
        for(int i = n / 2; i < n; i++){
            if(isVowel(s.charAt(i)) == true){
                second++;
            }
        }
        return first == second;
    }
}