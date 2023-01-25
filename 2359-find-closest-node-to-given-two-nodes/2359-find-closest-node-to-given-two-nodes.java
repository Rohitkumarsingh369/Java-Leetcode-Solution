class Solution {
    public void dfs(int u, int[] d, boolean[] vis, int[] edges) {
        // mark it visited
        vis[u] = true;
        // check the outgoing edge
        int v = edges[u];
        // -1 means there is no outgoing edge, so we skip it
        if (v != -1 && !vis[v]) {
            // the dist going to node v form node u is simply d[u] + 1
            d[v] = d[u] + 1;
            // dfs on neigbour node `v`
            dfs(v, d, vis, edges);
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        // d1[i]: shortest dist to node i starting from node 1
        // d2[i]: shortest dist to nodes i starting from node 2
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        // vis1[i]: true if node i is visited else false. used for building d1
        // vis2[i]: true if node i is visited else false. used for building d2
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        // dist to node1 from node1 is 0, same as node2 
        d1[node1] = d2[node2] = 0;
        // build the dist for d1
        dfs(node1, d1, vis1, edges);
        // build the dist for d2
        dfs(node2, d2, vis2, edges);
        // iterate each node to find the min max dist
        int ans = -1, mi = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (Math.max(d1[i], d2[i]) < mi) {
                mi = Math.max(d1[i], d2[i]);
                ans = i;
            }
        }
        return ans;
    }
}