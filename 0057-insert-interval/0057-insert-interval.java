class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int[] curInterval = intervals[i];
            if (intervals[i][1] < newInterval[0]) {
                // current interval starts first & not covered by newInterval, add intervals[i] to ans
                // [curInterval]
                //                      [newInterval]
                ans.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                // newInterval starts first and not covered by current interval
                // add newInterval to ans and set newInterval = curInterval
                //                       [curInterval]
                // [newInterval]
                ans.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                // they are overlapped, merge them
                // [curInterval]
                //        [newInterval]
                // or
                // [newInterval]
                //        [curInterval]
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // add the last interval
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
