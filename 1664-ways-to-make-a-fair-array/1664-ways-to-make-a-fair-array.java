class Solution {
    public int waysToMakeFair(int[] nums) {
        int length=nums.length;
        int totalEvenSum=0,totalOddSum=0;
        
        for(int i=0;i<length;i++){
            if(i%2==0){
                totalEvenSum+=nums[i];
            }
            else{
                totalOddSum+=nums[i];
            }
        }
        
        int leftEvenSum=0,leftOddSum=0;
        int count=0;
        for(int i=0;i<length;i++){
            if(i%2==0){
                totalEvenSum-=nums[i];
            }
            else{
                totalOddSum-=nums[i];
            }
            
            
            if(totalEvenSum + leftOddSum==totalOddSum + leftEvenSum){
                count++;
            }
            
            if(i%2==0){
                leftEvenSum+=nums[i];
            }
            else{
                leftOddSum+=nums[i];
            }
        }
        return count;        
    }
}