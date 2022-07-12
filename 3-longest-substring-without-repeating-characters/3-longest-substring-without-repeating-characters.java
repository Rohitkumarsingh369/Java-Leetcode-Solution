class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int lastindex[]=new int[256];
        Arrays.fill(lastindex,-1);
        int start=0,end=0;
        int i=0,res=0;
        for(int j=0;j<n;j++){
            i=Math.max(i,lastindex[s.charAt(j)]+1);
            
            if(res<j-i+1){
                res=j-i+1;
               /* start=i;
                end=j;*/
                
            }
           
            lastindex[s.charAt(j)]=j;
        }
       // System.out.println(s.substring(start,(end+1)));
        return res;
    }
}