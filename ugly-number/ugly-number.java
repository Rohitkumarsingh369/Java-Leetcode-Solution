class Solution {
    public boolean isUgly(int num) {
        int result=ugly(num);
        if(result>=1)
            return true;
        
    
        return false;
    }
    static int ugly(int n){
        //base case
        if(n==1)
            return 1;
        if(n<=0)
            return 0;
        
        //condition to check number is divided by 2,3 or 5
        if(n%2==0)
            return ugly(n/2);
        if(n%3==0)
            return ugly(n/3);
        if(n%5==0)
            return ugly(n/5);
        
        
        return 0;
    }
}