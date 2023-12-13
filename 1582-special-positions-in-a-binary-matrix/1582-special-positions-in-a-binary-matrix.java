class Solution {
    public int numSpecial(int[][] mat) {
        int special = 0;
        for (int[] line : mat) {
            special += (isGoodLine(line, mat) ? 1 : 0);
        }
        return special;
    }
    
    private boolean isGoodLine(int[] row, int[][] mat) {
        int lastPos = 0, rowSum = 0;
        for (int j = 0; j < row.length && rowSum < 2; j++) {
            if (row[j] == 1) {
                lastPos = j;
                rowSum++;
            }
        }
        return rowSum == 1 && colSum(lastPos, mat) == 1;
    }

    private int colSum(int col, int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length && sum < 2; i++) {
            sum += mat[i][col];
        }
        return sum;
    }
}