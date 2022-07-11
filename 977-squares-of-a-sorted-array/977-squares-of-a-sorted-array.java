class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 1){
            nums[0] = nums[0]*nums[0];
            return nums; 
        }
        else{
            int i = search(nums); // non -ve pointer
            int j = i - 1;//-ve pointer
            int count = 0;
            while (i < nums.length && j >= 0){
                if (nums[i] <= -1 * nums[j]){
                    ans[count] = nums[i]*nums[i];
                    count++;
                    i++;
                }else{
                    ans[count] = nums[j]*nums[j];
                    count++;
                    j--;
                }
            }
            while (i < nums.length){//square rest of the non negative values
                ans[count] = nums[i]*nums[i];
                count++;
                i++;
            }
            while (j >= 0){//square rest of the negative integers
                ans[count] = nums[j]*nums[j];
                count++;
                j--;
            }
        }
        return ans;
    }
    int search(int[] nums){//bs to find least non negative index
        int start = 0 , end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start)/2 ;
            if (nums[mid] < 0){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}