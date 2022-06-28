class Solution {
    public int minDeletions(String s) {
	int[] count = new int[26];
	for (char c: s.toCharArray()) count[c - 'a']++;

	Map<Integer, Integer> freqsMap = new HashMap<>();
	for (int n: count) if (n != 0) freqsMap.put(n, freqsMap.getOrDefault(n,0) + 1);

	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	for (int key: freqsMap.keySet()) pq.add(key);

	int deletions = 0;
	while (!pq.isEmpty()) {
		int val = pq.poll(), freq = freqsMap.get(val);
		deletions += freq - 1;
		if (freq > 1 && val > 1) {
			if (!freqsMap.containsKey(val-1)) pq.add(val-1);
			freqsMap.put(val-1, freqsMap.getOrDefault(val-1,0) + freq-1);
		}
	}

	return deletions;
}
/*Time complexity: O(n + klogk) where k represents the number of frequencies.
Space complexity: O(k) since each data structure is storing up to k different frequencies.*/
}