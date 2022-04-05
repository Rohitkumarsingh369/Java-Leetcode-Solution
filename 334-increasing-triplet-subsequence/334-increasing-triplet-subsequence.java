class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
    int big = Integer.MAX_VALUE;
 
    for (int num: nums) {
        if (num <= small) {
            small = num;// update x to be a smaller value
        } else if (num <= big) {
            big = num; // update y to be a smaller value
        } else {
            return true;
        }
    }
 
    return false;
    }
}