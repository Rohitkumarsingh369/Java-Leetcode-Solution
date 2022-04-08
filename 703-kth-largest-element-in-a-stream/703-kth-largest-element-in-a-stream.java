class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int i=0; i<nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.offer(val);             //adding values to Priority Queue
        if(pq.size() > k)        //We will maintain size of Priority queue with the given K
            pq.poll();              //if size is larger than k pop the element of pq in that case
        
        return pq.peek();      //return the top element of pq that will be our third largest
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */