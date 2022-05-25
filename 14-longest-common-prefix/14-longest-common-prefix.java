class Solution {
    public String longestCommonPrefix(String[] str) {
         // code here
        if(str.length==0 || str==null)
        return "";
        
        String lcp=str[0]; //Assuming that the first word is the ans (i.e- leetcode)
        for(int i=1;i<str.length;i++) //starts checking from the 2nd word in the array that's why i=1
        {
            //will check the length and compare the characters
            String currword=str[i]; //Stores the current words(for first it's - leetcode)
            int j=0;
            while(j<lcp.length() && j<currword.length() && lcp.charAt(j)==currword.charAt(j))
            {
                j++;
            }
            if(j==0) //while loop terminated at first execution only 
            {   //i.e. there's no common prefix may be the words are {hello, world}
                return "";
            }
            lcp=currword.substring(0,j);
        }
        return lcp;
    }
}