class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int start = 0;
	        int end = 1;
	        long product = arr[0];
	        int count = 0;
	        while (start <= end && end <= arr.length) {
	            if (product < k) {
	                count += end - start;
	                if (end < arr.length) product *= arr[end];
	                end++;
	            } else {
	                product /= arr[start++];
	            }
	        }
	        return count;
    }
}