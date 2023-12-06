class Solution {
    public int totalMoney(int n) {
       int count = 0;
        int i=1;
        while(i <= n){//run this from 1 to n
            int ans = i/7;
            int rem = i%7;
            if(rem == 0){
                count += (7 + ans -1);//only if no. is divisible by 7.
            }
            else{
                count += ans + rem; 
            }
            i++;
        }
        return count; 
    }
}