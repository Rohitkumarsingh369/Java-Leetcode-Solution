class Solution {
    public boolean isHappy(int n) {
        int a=n,d,rev;
         
        while(a>0)
        {
            int a1=a;
            rev=0;
            d=0;
            if (a1 == 1 || a1 == 7) {  
         return true;
         } else if (a1 <= 9) {
               return false;
        }
            while(a1>0){
                d=a1%10;
                rev=rev+(d*d);
                a1=a1/10;
            }
            
            if(rev==1)
                return true;
           
                a=rev;
        }
        return false;
    }
}
