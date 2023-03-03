class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
        return -1;
      
        int l=0,r=needle.length()-1;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int k=0;
            for(int j=l;j<=r;j++){
                if(needle.charAt(k++)!=haystack.charAt(j)){
                    l++;r++;
                    break;
                }
                if(j==r){
                    return l;
                }
            }

        }
        return -1;
    }
}