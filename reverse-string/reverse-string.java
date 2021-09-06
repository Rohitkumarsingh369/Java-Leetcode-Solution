class Solution {
    public void reverseString(char[] s) {
        int length=s.length;
        
        int pos=length-1;
        for(int i=0;i<length/2;i++){
            char temp=s[i];
            s[i]=s[pos];
            s[pos]=temp;
            pos--;
        }
    
    }
}