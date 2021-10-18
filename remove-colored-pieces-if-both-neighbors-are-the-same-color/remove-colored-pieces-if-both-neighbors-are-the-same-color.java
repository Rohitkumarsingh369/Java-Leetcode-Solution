class Solution {
    public boolean winnerOfGame(String colors) {
        
        int len=colors.length();
        
        int acount=0;
        int bcount=0;
        
        for(int i=1;i<len-1;i++){
            if(colors.charAt(i-1)==colors.charAt(i) && colors.charAt(i+1)==colors.charAt(i) )
            {
                if(colors.charAt(i)=='A')
                    acount++;
                else
                    bcount++;
            }
        }
        
        return acount>bcount;
    }
}