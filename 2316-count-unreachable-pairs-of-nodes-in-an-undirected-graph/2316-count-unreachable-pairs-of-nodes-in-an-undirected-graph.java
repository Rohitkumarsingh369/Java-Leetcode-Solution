class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public long countPairs(int n, int[][] edges) {
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        long sum = (Long.valueOf(n)*(n-1))/2;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++)
            if(!visited[i]){
                int cnt = dfs(i, visited, new int[1]);
                sum -= (Long.valueOf(cnt) * (cnt-1))/2;
            }
        return sum;
    }

    int dfs(int node, boolean[] visited, int[] count){ 
        if(visited[node]) return count[0];
        visited[node] = true;
        count[0]++;
        for(int curr : graph.get(node))
            dfs(curr, visited, count);
        return count[0];
    }
}