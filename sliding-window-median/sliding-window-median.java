class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return Integer.compare(b, a);
        }
    });
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return result;
    }

    private void add(int num) {
        if (num > getMedian()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        rebalance();
    }

    private void remove(int num) {
        if (num > getMedian()) {
            minHeap.remove(num);
        } else {
            maxHeap.remove(num);
        }
        rebalance();
    }

    private double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        } 
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }

    private void rebalance() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
}