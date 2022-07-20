class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    int max=0;
    int currentMax=0;
    for(int i : nums){
        if(i==1){
            currentMax++;
        }else{
            if(currentMax>max){
                max=currentMax;
            }
            currentMax = 0;
        }
    }
    return Math.max(max,currentMax);
}
}