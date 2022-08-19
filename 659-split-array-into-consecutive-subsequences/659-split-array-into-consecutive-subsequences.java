class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet().size());
        for (int num : map.keySet()) {
            queue.add(num);
        }

        while (!queue.isEmpty()) {
            int min = queue.peek();
            int count = 0;
            while (true) {
                if (!map.containsKey(min)) { 
				    // no consecutive number, if count is not 3 at least, return false immediately
                    if (count < 3) return false;
					// otherwise break because we cannot add more number to the current group since it would not be consecutive
                    break;
                }
                map.put(min, map.get(min) - 1);
                count++;
                if (map.get(min) == 0) {
				    // if the current minimum doesn't not match with the min in the heap, it means that the min value is gonna become isolated and we will never be able to add it to any group, so return false immediately
                    if (min != queue.peek()) return false;
					// no more occurrences in the map, so remove it also from the queue
                    queue.poll();
                }
				// if the occurrences of current value (min) (+1 because we just removed it from the map) are bigger than the next one, we cannot add numbers anymore to the current group because otherwise the current value would become isolated
                if (map.containsKey(min + 1) && map.get(min) + 1 > map.get(min + 1)) {
                    // I need to break, cannot add more numbers to the current group anymore
                    if (count < 3) return false; // when I break if, count is less than 3, again return immediately false
                    break;
                }

                min += 1; // update our minimum in search for another value to append to the current group
            }
        }
		// if false was never returned, we were able to build up the groups and can return true
        return true;
    }
}