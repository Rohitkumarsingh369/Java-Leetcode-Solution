class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right+=w;
        }
        while (left < right) {
            int mid = left+(right-left)/2, days = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    days += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (days > D) left = mid + 1;
            else right = mid;
            
        }
        return left;
    }
}