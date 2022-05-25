class Solution {
    public String longestCommonPrefix(String[] arr) {
          // code here
        int n=arr.length;
        if(n==0 || arr==null)
        return "";
        
        String lcp=arr[0]; //Assuming that the first word is the ans (i.e- geeksforgeeks)
        for(int i=1;i<n;i++) //starts checking from the 2nd word in the array that's why i=1
        {
            //will check the length and compare the characters
            String currword=arr[i]; //Stores the current words(for first it's - geeks)
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