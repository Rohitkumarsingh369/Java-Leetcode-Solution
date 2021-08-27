class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        int right = sum;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(weights, mid, D)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public boolean isPossible(int[] weights, int mid, int D) {
        int limit = 1;
        int curr = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > mid) {
                return false;
            }
            if (weights[i] + curr > mid) {
                curr = weights[i];
                limit++;
                if (limit > D) {
                    return false;
                }
            } else {
                curr += weights[i]; 
            }
            
        }
        return true;
    }
}