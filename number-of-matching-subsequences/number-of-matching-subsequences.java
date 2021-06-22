class Solution {
    
    
    /* Approach: For every word, check if it is subsequence of input string */
    
    public int numMatchingSubseq(String s, String[] words) {
        
        String inputString = s;
        int count = 0;
        
        // Check for every words in array
        
        for (String word: words) {
            
             // Check if word is subsequence of input string
                 
            if (checkSubsequence(word, inputString)) {
                count = count + 1;
            }
            
        }
        
        return count;
    }
    
    
    /* Helper function to check if given word is sub sequence of given input string */
    
    private boolean checkSubsequence (String word, String inputString) {
        
        int prevCharIndex = 0;   // It will store the index of input String where previous char was found
        
        /*  So, the curr character should be found after this index for maintaining subsequence order  */
                
        for (char ch : word.toCharArray()) {
            
            int index = inputString.indexOf(ch, prevCharIndex);   // search for char after prev char found index
            
            // If index == -1 means char not found, else found at index i.
            
            if (index == -1) {
                return false;
            }
            
            prevCharIndex = index + 1;   // set the prevCharIndex to current found char index + 1 for next search
            
            // We do index + 1 as maybe duplicate elements consider this same index twice, so increment by 1.
            
        }
        
        return true;   // Every chars traversed and found, return true.
        
    }
    
    
}