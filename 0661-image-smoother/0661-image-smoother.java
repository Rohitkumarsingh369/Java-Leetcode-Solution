class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int res[][] = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = 0, count = 0;

                for(int r = Math.max(0, i - 1); r <= Math.min(n - 1, i + 1); r++) {
                    for(int c = Math.max(0, j - 1); c <= Math.min(m - 1, j + 1); c++) {
                        sum += img[r][c];
                        count++;
                    }
                }

                int avg = (int) (sum / count);
                res[i][j] = avg;
            }
        }   

        return res;
    }
}