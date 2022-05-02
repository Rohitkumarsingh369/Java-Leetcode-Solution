class Solution {
   /*  public int countSubstrings(String s) {
         int length=s.length();
         int dp[][]=new int[length][length];
         
         int count=0;
         
         for(int size=0;size<length;size++){
             for(int left=0,right=size;right<length;left++,right++){
                 if(size==0){
                     dp[left][right]=1;
                 }
                 else if(size==1){
                     if(s.charAt(left)==s.charAt(right))
                         dp[left][right]=1;
                     else
                         dp[left][right]=0;
                 }
                 else{
                     if(s.charAt(left)==s.charAt(right) && dp[left+1][right-1]==1)
                         dp[left][right]=1;
                     else
                         dp[left][right]=0;
                 }
                 
                 
                 if(dp[left][right]==1)
                     count++;
                     
             }
         }
         return count;
     }*/
    
    public int countSubstrings(String s){
        String temp="";
        StringBuffer stf;
        
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                temp=s.substring(i,j);
                
                if(temp.length()>=1){
                    stf=new StringBuffer(temp);
                    stf.reverse();
                    
                    if(stf.toString().compareTo(temp)==0)
                        count++;
                }
            }
        }
        
        return count;
    }
}