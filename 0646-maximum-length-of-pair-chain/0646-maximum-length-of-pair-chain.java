class Solution {
    public int findLongestChain(int[][] pairs) {
        final int N = pairs.length;
        if (N <= 1) return N;
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        int res = 1;
        int last = pairs[0][1];
        for (int i = 0; i < N; i++) {
            if (pairs[i][0] > last) {
                last = pairs[i][1];
                res++;
            }
        }
        return res;
    }
}