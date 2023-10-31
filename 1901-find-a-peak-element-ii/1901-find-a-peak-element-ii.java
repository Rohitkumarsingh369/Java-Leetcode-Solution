class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
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

    return null; // No peak found (this should not happen given the constraints)
    }
}