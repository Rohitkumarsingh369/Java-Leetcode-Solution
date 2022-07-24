class Solution {
    public int reachNumber(int target) {
        int sum = 0, jump = 1;
        target = Math.abs(target);
        while(sum < target){
            sum += jump;
            jump++;
        }
        
        if((sum - target)%2 == 0){
            return jump-1;
        } 
        else if((sum+jump-target)%2 == 0){
            return jump;
        } 
        else    return jump+1;
    }
}