/*class Solution {
int total =0;
    public int minReorder(int n, int[][] connections) {
        //note can not add new Edge
        Map<Integer, List<Integer>>  map = new HashMap<>();
        Set<String> direction = new HashSet<>();
        
        for(int[] connection : connections){
            int a = connection[0], b = connection[1];
            direction.add(a+"-"+b);

            if(!map.containsKey(b)) map.put(b, new ArrayList());
            if(!map.containsKey(a)) map.put(a, new ArrayList());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        dfs(0, map, direction, new int[n]);
        return n-1-total;
    }
    
    public void dfs(int source, Map<Integer, List<Integer>> map, Set<String> direction, int[] visited){
        if(visited[source]==1) return;
        visited[source] = 1;
        
        for(int child : map.get(source)){
            if(visited[child]==1) continue;
            if(!direction.contains(source+"-"+child)){
                total++;
            }
            dfs(child, map, direction, visited);
        }
    }

}*/
class Solution {
  public int minReorder(int n, int[][] connections) {
    List<Integer>[] graph = new List[n];

    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();

    for (int[] conn : connections) {
      graph[conn[0]].add(conn[1]);
      graph[conn[1]].add(-conn[0]); // - := conn[0] -> conn[1]
    }

    return dfs(graph, 0, -1);
  }

  private int dfs(List<Integer>[] graph, int u, int parent) {
    int change = 0;

    for (final int v : graph[u]) {
      if (Math.abs(v) == parent)
        continue;
      if (v > 0)
        ++change;
      change += dfs(graph, Math.abs(v), u);
    }

    return change;
  }
}
