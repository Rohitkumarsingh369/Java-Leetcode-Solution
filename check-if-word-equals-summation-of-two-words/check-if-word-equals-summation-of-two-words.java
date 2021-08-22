class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
         int val1=decode(firstWord);
         int val2=decode(secondWord);
         int val3=decode(targetWord);
        
        return val1+val2==val3;
    }
    
    public int decode(String word){
        int ans=0;
        
        for(char c:word.toCharArray()){
            
            int val=(int)(c-'a');
            ans=ans*10+val;
        }
        return ans;
    }
    
}