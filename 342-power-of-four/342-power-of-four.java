class Solution {
    public boolean isPowerOfFour(int n) {
        while (n > 1) {
            if (n % 4 != 0) 
                return false;
            n >>= 2;
        }   
        return n == 1;
    }
}