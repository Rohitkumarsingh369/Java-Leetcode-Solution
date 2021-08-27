class Solution {
    public int longestSubstring(String s, int k) {
        int freq[]=new int[26];
        
        int max=Integer.MIN_VALUE;
        int len=s.length();
        for(int i=0;i<len;i++){
            Arrays.fill(freq,0);
            
            for(int j=i;j<len;j++){
                freq[s.charAt(j)-'a']++;
                
                if(atleast(freq,k)){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        
        return max==Integer.MIN_VALUE?0:max;
    }
    
    public boolean atleast(int freq[],int k){
        
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0 && freq[i]<k)
                return false;
            
        }
        return true;
    }
}