class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> matrix[p1[0]][p1[1]] - matrix[p2[0]][p2[1]]);
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        pq.offer(new int[]{0, 0});
        set.add(new Pair(0, 0));
        while(--k > 0) {
            int[] min = pq.poll();
            if(min[1] + 1 < matrix.length && !set.contains(new Pair(min[0], min[1] + 1))) {
                pq.offer(new int[]{min[0], min[1] + 1});
                set.add(new Pair(min[0], min[1] + 1));
            }
            if(min[0] + 1 < matrix.length && !set.contains(new Pair(min[0] + 1, min[1]))) {
                pq.offer(new int[]{min[0] + 1, min[1]});
                set.add(new Pair(min[0] + 1, min[1]));
            }
        }
        int[] ri = pq.peek(); 
        return matrix[ri[0]][ri[1]];
    }
}