class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int xmin = m , ymin = n ;
        for(int op[]:ops){
            xmin = Math.min(xmin,op[0]);
            ymin = Math.min(ymin,op[1]);
        }
        return xmin*ymin;
    }
}