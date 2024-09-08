class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) return new int[0][0];

        // Sort intervals based on the starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= currentInterval[1]) {
                // There is an overlap
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // No overlap
                currentInterval = interval;
                mergedList.add(currentInterval);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}