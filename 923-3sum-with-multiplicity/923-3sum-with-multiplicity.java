class Solution {
    private static final int  m = 1_000_000_007;
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < target - A[i]) { ++j; }
                else if (A[j] + A[k] > target - A[i]) { --k; }
                else {
                    if (A[j] == A[k]) {
                        // If A[j...k] are all equal, then there are C(k - j + 1, 2) 
                        // combinations that meet the requirement.
                        res = (res + (k - j + 1) * (k - j) / 2) % m;
                        break;
                    }
                    int l = 1, r = 1;
                    while (j + l < k && A[j + l] == A[j]) { ++l; } // l: number of elements equal to A[j].
                    while (j < k - r && A[k - r] == A[k]) { ++r; } // r: number of elements equal to A[k].
                    res = (res + l * r) % m; // found l * r cases that meet the requirement.
                    j += l; // forward j by l steps.
                    k -= r; // backward k by r steps.
                }
            }
        }
        return res;
    }
}