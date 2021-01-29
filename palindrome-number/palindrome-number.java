class Solution {
    public boolean isPalindrome(int n) {
        int a=n,d=0,rev=0;
        while(a>0){
            d=a%10;
            rev=rev*10+d;
            a=a/10;            
        }
        if(rev==n)
            return true;
        
    return false;
    }
}
