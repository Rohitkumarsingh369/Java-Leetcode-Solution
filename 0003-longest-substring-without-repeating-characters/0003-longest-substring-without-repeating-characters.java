class Solution {
    /*public int lengthOfLongestSubstring(String s) {
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
    }*/
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}