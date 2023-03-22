class Solution {
    public int dijkstra(Map<Integer, List<int[]>> adjMap, int n, int[] distance) {
        distance[1] = 10005;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.add(new int[] {1,10005});
        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            for(int[] next: adjMap.get(node[0])) {
                if(Math.min(node[1],next[1])<distance[next[0]]) {
                    distance[next[0]] = Math.min(node[1],next[1]);
                    minHeap.add(new int[] {next[0], distance[next[0]]});
                }
            }
        }
        return distance[n];
    }
    public void formAdjMap(int[][] roads, Map<Integer, List<int[]>> adjMap) {
        for(int[] road: roads) {
            adjMap.get(road[0]).add(new int[] {road[1], road[2]});
            adjMap.get(road[1]).add(new int[] {road[0], road[2]});
        }
    }
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        int[] distance = new int[n+1];
        for(int i=1;i<=n;i++) {
            adjMap.put(i, new ArrayList<>());
            distance[i] = 10005;
        }
        formAdjMap(roads, adjMap);
        return dijkstra(adjMap, n, distance);
    }
}