class Solution {
   
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);

        for (int i = 0; i < graph.length; i++) {
            int[] edges = graph[i];
            for (int node : edges) {
                if (uf.find(i) == uf.find(node))
                    return false;
                uf.union(edges[0], node);
            }
        }
        return true;
    }


    public static class UnionFind {

        private final int[] root;

        public UnionFind(int size) {
            this.root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int node) {
            if (root[node] == node)
                return node;
            return find(root[node]);
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 != root2) {
                root[root1] = root2;
            }
        }
    }
}