class Solution {
    public int minCut(String str) {
        int len=str.length();
        int cut[]=new int[len];
        boolean palin[][]=new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            palin[i][i] = true;
        }
        
        for(int L=2;L<=len;L++){
            for(int i=0;i<len-L+1;i++){
                int j=i+L-1;
                
                if(L==2)
                    palin[i][j]=(str.charAt(i)==str.charAt(j));
                else
                    palin[i][j]=(str.charAt(i)==str.charAt(j)) && palin[i+1][j-1];
            }
        }
        
        for(int i=0;i<len;i++){
            if(palin[0][i]==true)
                cut[i]=0;
            else{
                cut[i]=Integer.MAX_VALUE;
                
                for(int j=0;j<i;j++){
                    if(palin[j+1][i]==true && 1+cut[j]<cut[i])
                        cut[i]=1+cut[j];
                }
            }
            
        }
        return cut[len-1];
    }
}