class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i)
            engineers[i] = new int[] {efficiency[i], speed[i]};
        
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]); // Sort by decreasing order of efficiency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long res = 0, speedSum = 0;
        for (int[] engineer : engineers) {
            int e = engineer[0], s = engineer[1];
            minHeap.add(s);
            speedSum += s;
            if (minHeap.size() > k) { // Over k engineers -> remove the lowest speed engineer
                speedSum -= minHeap.poll();
            }
            res = Math.max(res, (speedSum * e));
        }
        return (int) (res % (long)(1e9 + 7));
    }
}