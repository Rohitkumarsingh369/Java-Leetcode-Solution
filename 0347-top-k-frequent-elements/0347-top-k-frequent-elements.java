class Solution {
    
   /* public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
    
            for (int n : nums) {
                if (countMap.containsKey(n)) {
                    countMap.put(n ,countMap.get(n)+1);
                } else {
                    countMap.put(n ,1);
                }
            }
           PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
            pq.addAll(countMap.entrySet());

    int result[]=new int[k];
    //List<Integer> ret = new ArrayList<>();
    for(int i = 0; i < k; i++){
        result[i]=(pq.poll().getKey()).intValue();
    }
    return result;
    }*/
    
    public int[] topKFrequent(int[] nums, int k){
       // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min-Heap (PriorityQueue) to keep track of the top k frequent elements
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        
        // Step 3: Add elements to the heap
        for (int num : frequencyMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();  // Remove the least frequent element
            }
        }

        // Step 4: Extract the top k frequent elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}