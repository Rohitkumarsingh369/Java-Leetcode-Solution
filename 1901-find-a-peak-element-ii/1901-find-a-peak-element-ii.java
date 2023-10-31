class Solution {
    public int[] findPeakGrid(int[][] mat) {
       /* int m = mat.length;
    int n = mat[0].length;
    
    int left = 0, right = m - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Find the maximum element in the middle column
        int maxRow = 0;
        for (int i = 1; i < n; i++) {
            if (mat[mid][i] > mat[mid][maxRow]) {
                maxRow = i;
            }
        }

        // Check if mat[mid][maxRow] is a peak
        boolean isPeak = true;
        if (mid > 0 && mat[mid - 1][maxRow] > mat[mid][maxRow]) {
            isPeak = false;
            right = mid - 1;
        } else if (mid < m - 1 && mat[mid + 1][maxRow] > mat[mid][maxRow]) {
            isPeak = false;
            left = mid + 1;
        }

        if (isPeak) {
            return new int[]{mid, maxRow};
        }
    }

    return null; // No peak found (this should not happen given the constraints)*/
        int row = 0, col = 0;
while (true) {
    int current = mat[row][col];
    
    int up = row != 0 ? mat[row - 1][col] : 0;
    int down = row != mat.length - 1 ? mat[row + 1][col] : 0;
    int left = col != 0 ? mat[row][col - 1] : 0;
    int right = col != mat[0].length - 1 ? mat[row][col + 1] : 0;

    if (up > current) {
        row = row - 1;
    } else if (down > current) {
        row = row + 1;
    } else if (right > current) {
        col = col + 1;
    } else if (left > current) {
        col = col - 1;
    } else {
        return new int[] { row, col };
    }
}

    }
}