class Solution {
    public int missingNumber(int[] nums) {
         int n = nums.length;
        // Sum = (no. of elements + 1)(1st element + last element)/2
        int expectedSum = (n+1)*(0+n)/2;
        
        int actualSum = 0;
        for(int i : nums)
            actualSum += i;
        
        return expectedSum - actualSum;
    }
}