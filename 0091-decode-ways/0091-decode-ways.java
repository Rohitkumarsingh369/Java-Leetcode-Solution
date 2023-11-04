/*class Solution {
    public int numDecodings(String str) {
        int n=str.length();
       
        int count[]=new int[n+1];
        
        count[0]=1;
        count[1]=1;
        
        if(str.charAt(0)=='0')
        return 0;
        for(int i=2;i<=n;i++){
            count[i]=0;
            if(str.charAt(i-1)>'0')
                count[i]=count[i-1];
            
            if((str.charAt(i-2)=='1'||(str.charAt(i-2)=='2')&& str.charAt(i-1)<'7'))
                count[i]+=count[i-2];
        }
        
        return count[n];
    }
}*/

class Solution {
    public int numDecodings(String str){
        if(str.isEmpty() || str.charAt(0)=='0')
            return 0;
        
        int twoStepBack=1;
        int oneStepBack=1;
        
        for(int i=2;i<=str.length();i++){
            char currentChar=str.charAt(i-1);
            
            int curr=0;
            
            if(currentChar!='0'){
                curr=oneStepBack;
            }
            
            char previousChar=str.charAt(i-2);
            if(previousChar=='1'|| previousChar=='2' && currentChar<'7'){
                curr+=twoStepBack;
            }
            twoStepBack=oneStepBack;
            oneStepBack=curr;
        }
        return oneStepBack;
    }
}