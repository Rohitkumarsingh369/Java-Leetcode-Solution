class Solution {
    public int largestPerimeter(int[] nums) {
        
        //Sort the array first.
        Arrays.sort(nums);
        
        //Start traversing from back , so that we can get the largest value.
        for(int i = nums.length-1; i>1; i--){
            //Using triangle property to become valid sides
            // The sum of the length of the two sides of a triangle is greater than the length of the third side. 
           if(nums[i] < nums[i-1] + nums[i-2])
               return  nums[i] + nums[i-1]+ nums[i-2];   
        }
        
        //If we didn't found anything we return 0.
        return 0;
    }
   
}