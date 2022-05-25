class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int lastindex[]=new int[256];
        Arrays.fill(lastindex,-1);
        int i=0,res=0;
        for(int j=0;j<n;j++){
            i=Math.max(i,lastindex[s.charAt(j)]+1);
            res=Math.max(res,j-i+1);
            lastindex[s.charAt(j)]=j;
        }
        return res;
    }
}