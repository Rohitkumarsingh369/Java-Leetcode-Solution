class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length + 1 < n) return -1;
        int[] union = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
            rank[i] = 1;
        }
        for (int[] conn: connections) {
            union(union, rank, conn[0], conn[1]);
            // System.out.println(Arrays.toString(union));
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(find(union, i));
        }
        // System.out.println(res);
        return res.size() - 1;

    }

    private int find(int[] union, int u) {
        if (union[u] == u) {
            return u;
        }
        return union[u] = find(union, union[u]);
    }

    private void union(int[] union, int[] rank, int u, int v) {
        int ru = find(union, u);
        int rv = find(union, v);
        if (rank[ru] < rank[rv]) {
            union[ru] = rv;
        } else if (rank[ru] > rank[rv]) {
            union[rv] = ru;
        } else {
            union[ru] = rv;
            rank[rv]++;
        }
    }
}