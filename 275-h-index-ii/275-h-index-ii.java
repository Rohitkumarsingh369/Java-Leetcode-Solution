class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        int hi = n-1;
        int lo = 0;
        while(lo<=hi) {
            int mid = (lo+hi) / 2;
            if(citations[mid] == n-mid) {
                return n-mid;
            } else if(citations[mid] > n-mid) {
                hi = mid-1;;
            } else {
                lo = mid+1;
            }
        }
        return n-lo;
    }
}