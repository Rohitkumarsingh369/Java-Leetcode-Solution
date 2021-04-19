class Solution {
    public int minAddToMakeValid(String S) {
        int bal=0,ans=0;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')
                bal++;
            else
                bal--;
            if(bal==-1){
                bal++;
                ans++;
            }
        }
        return bal+ans;
    }
}