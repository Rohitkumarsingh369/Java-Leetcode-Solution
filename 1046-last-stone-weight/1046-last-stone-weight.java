class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int st : stones) { q.offer(st); }
        while (q.size() > 1) {
            q.offer(q.poll() - q.poll());
        }
        return q.peek();
    
    }
}