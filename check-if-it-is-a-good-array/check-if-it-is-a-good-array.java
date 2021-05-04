class Solution {
    public boolean isGoodArray(int[] A) {
        int x = A[0], y;
        for (int a: A) {
            while (a > 0) {
                y = x % a;
                x = a;
                a = y;
            }
        }
        return x == 1;
    }
}