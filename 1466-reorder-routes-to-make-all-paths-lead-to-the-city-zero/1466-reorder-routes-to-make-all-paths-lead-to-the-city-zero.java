class Solution {
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

}