class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        int lastindex[]=new int[256];
        Arrays.fill(lastindex,-1);
        int left=0,resultlength=0,end=0;
        
        for(int right=0;right<length;right++){
            left=Math.max(left,lastindex[s.charAt(right)]+1);
            
            if(resultlength<(right-left+1)){
                resultlength=right-left+1;
                end=right;
            }
            lastindex[s.charAt(right)]=right;
        }
        return resultlength;
    }
}