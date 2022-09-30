class Solution {
    public List<List<Integer>> getSkyline(int[][] B) {
        //think of this array as bars representing borders of buildings
        int[][] H = new int[2 * B.length][2];
        for (int i = 0; i < B.length; i++) {
            H[i * 2] = new int[]{B[i][0], -B[i][2]}; //left, -height
            H[i * 2 + 1] = new int[]{B[i][1], B[i][2]}; //right, height
        }
        //sort the bars based on position, use height as tie-breaker
        Arrays.sort(H, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        //reason for not choosing priority queue is removal of given item other than root can be costly O(n)
        //reason for not choosing TreeSet is to accommodate duplicates
        var map = new TreeMap<Integer, Integer>(Comparator.reverseOrder()); //height is key, count is val
        map.put(0, 1); //one building of zero height is needed
        List<List<Integer>> res = new ArrayList<>();
        int prev = 0;
        for (int[] h : H) {
            //-ve height for left bar meaning validity of this building is starting, add it
            if (h[1] < 0) map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            else { //+ve height for right bar meaning end of validity, remove it
                map.put(h[1], map.get(h[1]) - 1);
                if (map.get(h[1]) == 0) map.remove(h[1]); //could have been costly for priority queue
            }
            if (map.firstKey() != prev) { //max height in curr position that is diff from prev, add to skyline
                prev = map.firstKey();
                res.add(List.of(h[0], prev));
            }
        }
        return res;
    }
}