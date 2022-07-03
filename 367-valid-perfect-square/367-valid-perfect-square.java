class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        
        int low=1,high=num/2;
        
        while(low<=high){
            long mid=low+(high-low)/2;
            
            if(mid*mid==num){
                return true;
            }
            else if((int)mid*mid>num){
                high=(int)mid-1;
            }
            else{
                low=(int)mid+1;
            }
        }
        
        return false;
       /* int i = 1;
     while (num > 0) {
         num -= i;
         i += 2;
     }
     return num == 0;*/
    }
}