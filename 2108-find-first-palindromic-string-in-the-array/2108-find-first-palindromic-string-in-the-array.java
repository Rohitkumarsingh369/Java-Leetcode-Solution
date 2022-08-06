class Solution {
    public String firstPalindrome(String[] words) {
        boolean check=false;
        int res=0;
       for(int i=0;i<words.length;i++){
           check=isPalindrome(words[i]);
           if(check==true)
           {
               res=i;
               break;
           }
        
       }
        return check?words[res]:"";
    }
    public boolean isPalindrome(String word){
        int ptr1=0;
        int ptr2=word.length()-1;
        while(ptr1<ptr2){
            if(word.charAt(ptr1)==word.charAt(ptr2)){
                ptr1++;
                ptr2--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}