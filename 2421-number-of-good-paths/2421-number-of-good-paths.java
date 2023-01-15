class Solution {
    int[] parent, count; // parent array to keep track of parent of each node and count array to keep track of number of nodes in each set
    int res; // variable to store the number of good paths
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // sort edges based on the maximum value of the nodes in the edge
        Arrays.sort(edges, (o1, o2) -> Integer.compare(Math.max(vals[o1[0]], vals[o1[1]]), Math.max(vals[o2[0]], vals[o2[1]])));       
        int n = vals.length;      
        res = n; // initialize number of good paths to be equal to number of nodes
        parent = new int[n];
        count = new int[n];

        Arrays.fill(count, 1); // initialize count of nodes in each set to be 1
        
        for(int i = 0; i < n; i++) parent[i] = i; // initialize parent of each node to be itself
        for(int[] edge: edges) {
            union(edge[0], edge[1], vals);
        }
        return res;
    } 
    // function to merge two sets
    private void union(int x, int y, int[] vals) {
        int parx = find(x);
        int pary = find(y);
        if(parx == pary) return; // if x and y are already in the same set, return
        if(vals[parx] == vals[pary]) {
            // if the values of the parents of x and y are equal, update number of good paths
            res += count[parx]*count[pary];
            count[parx] += count[pary];
            parent[pary] = parx;
        } 
        else if(vals[parx] > vals[pary]) {
            parent[pary] = parx;
        } else {
            parent[parx] = pary;
        }
    }
    // function to find the parent of a node
    private int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
}