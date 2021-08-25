class Solution {
    public String longestPrefix(String s) {
        
        int len=s.length();
        String result="";
        if(len==1)
            return result;
        int lps[]=new int[len];
        computelpsarray(lps,s,len,result);
        
       
        return s.substring(0,lps[len-1]);
    }
    public void computelpsarray(int []lps,String pat,int m,String result){
         lps[0]=0;
        
        int len=0,i=1;
        
        int max=Integer.MIN_VALUE;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                
                
                if(max<lps[i] ){
                    max=lps[i];
                    result=pat.substring(0,i+1);
                }
                i++;
            }
            else{
                if(len!=0)
                    len=lps[len-1];
                
                else{
                    lps[i]=len;
                    i++;
                }
            }
        }
    }
}