class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int idx = 0;
        int i = getIdxOfFirstPostive(arr);
        int j = i - 1;
        while (i < n && j >= 0) {
            if (-1 * arr[j] > arr[i]) {
                ans[idx++] = arr[i] * arr[i];
                i++;
            } else {
                ans[idx++] = arr[j] * arr[j];
                j--;
            }
        }
        while (i < n) {
            ans[idx++] = arr[i] * arr[i];
            i++;
        }
        while (j >= 0) {
            ans[idx++] = arr[j] * arr[j];
            j--;
        }
        return ans;
    }
    int getIdxOfFirstPostive(int[] arr) {
        int start = 0, end = arr.length - 1, ans = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}