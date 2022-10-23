class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int[] ans = new int[2];
        while( i < nums.length ) {
            int correct = nums[i] - 1;
            if( nums[i] != nums[correct] ){
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k + 1){
            ans[1] = k + 1;
                ans[0] = nums[k];
             //   break;
            }
        }
         return ans;
    }
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}