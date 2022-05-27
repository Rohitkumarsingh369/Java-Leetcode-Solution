class Solution {
    public int numberOfSteps(int num) {
        
        int count=0;
        while(num>0){
            if(num%2!=0){
                num-=1;
                count++;
            }
            else if(num%2==0){
                num/=2;
                count++;
            }
        }
        return count;
    }
}