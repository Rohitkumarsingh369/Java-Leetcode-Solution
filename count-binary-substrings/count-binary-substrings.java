class Solution {
   
public int countBinarySubstrings(String s) {
        int prev=0, curr=1 , ans=0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ans+=Math.min(curr,prev);
                prev=curr;
                curr=1;
            }else{
                curr++;
            }
        }
        
         return ans+Math.min(curr,prev);
    }
}