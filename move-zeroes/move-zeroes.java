class Solution {
    public void moveZeroes(int[] nums) {
         
        int count=0,temp=0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] != 0)) {
                temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count = count + 1;
            }
        }
    }
}