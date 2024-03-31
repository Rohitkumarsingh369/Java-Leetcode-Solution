class Pair {
        int dest;
        int time;

        Pair(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int source = edge[0];
            int destination = edge[1];
            int time = edge[2];
            adj.get(source).add(new Pair(destination, time));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        dist[K] = 0;
        queue.add(new Pair(K, 0));

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int currentNode = node.dest;

            for (Pair neighbor : adj.get(currentNode)) {
                int neighborNode = neighbor.dest;
                int neighborTime = neighbor.time;

                if (dist[currentNode] + neighborTime < dist[neighborNode]) {
                    dist[neighborNode] = dist[currentNode] + neighborTime;
                    queue.add(new Pair(neighborNode, dist[neighborNode]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}