class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] Closure=new boolean[numCourses][numCourses];
        
        List<Integer> [] graph=new List[numCourses];
        int [] inDegree=new int[numCourses]; //topological sorting
        
        Arrays.setAll(graph, i-> new ArrayList<>());
        
        for(int [] prerequisite: prerequisites){
            graph[prerequisite[0]].add(prerequisite[1]);
            ++inDegree[prerequisite[1]];
        }
        
        Deque<Integer> queue=new ArrayDeque<>();
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course=queue.poll();
            
            //check all the node link with it
            for(int node: graph[course]){
                Closure[course][node]=true;
                
                for(int preCourse=0;preCourse<numCourses;preCourse++){
                    Closure[preCourse][node]|=Closure[preCourse][course];
                }
                
                if(--inDegree[node]==0){
                    queue.add(node);
                }
            }
        }
        
        List<Boolean> result=new ArrayList<>();
        
        for(int [] query: queries){
            result.add(Closure[query[0]][query[1]]);
        }
        
        return result;
    }
}