class Solution {
    public int numberOfSteps (int num) {
        int count=0;
        
        if(num==0)
            return 0;
        
        while(num>0){
            if(num%2!=0){
                num=num-1;
                count++;
            }
            else if(num%2==0){
                num=num/2;
                count++;
            }
        }
        return count;
    }
}