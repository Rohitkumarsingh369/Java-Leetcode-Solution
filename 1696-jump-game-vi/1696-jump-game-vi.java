class Solution {
  public int maxResult(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> deque = new LinkedList<>() {{
            offer(new Pair<>(0, nums[0]));
        }};
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst().getKey() < i - k) {
                deque.pollFirst();
            }

            max = nums[i] + (deque.isEmpty() ? 0 : deque.peekFirst().getValue());

            while (!deque.isEmpty() && deque.peekLast().getValue() <= max) {
                deque.pollLast();
            }

            deque.offerLast(new Pair<>(i, max));
        }

        return max;
    }
}