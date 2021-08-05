class Solution {
     private static final int UNVISITED = 0;
    private static final int ACTIVE = 1;
    private static final int DONE = 2;
    
    // build a directed graph, detct cycle (using DFS)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0 = unvisited, 1 = active, 2 = done
        int[] visited = new int[numCourses];
        
        // build a directed graph based on prerequisites
        List<Integer>[] edges = new List[numCourses];
        for (int i=0; i<numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] p : prerequisites) {
            // {a,b} --> must take b before a --> edge from b to a
            edges[p[1]].add(p[0]);
        }
        
        for (int i=0; i<numCourses; i++) {
            if (visited[i] == UNVISITED) {
                if (visit(visited, edges, i)) {
                    // found a cycle = can't finish all courses
                    return false;
                }
            }
        }
        return true;
    }
    
    // DFS over directed graph
    // return true if encountered a cycle
    private static boolean visit(int[] visited, List<Integer>[] edges, int curNode) {
        visited[curNode] = ACTIVE;
        for (int nei : edges[curNode]) {
            if (visited[nei] == ACTIVE) {
                // reached an active node = nei is part of a cycle
                return true;
            }
            if (visited[nei] == UNVISITED) {
                if (visit(visited, edges, nei)) {
                    return true;
                }
            }
        }
        visited[curNode] = DONE;
        return false;
    }
}