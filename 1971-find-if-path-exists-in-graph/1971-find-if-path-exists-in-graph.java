class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Integer> [] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int []edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean visited[]=new boolean[n];
        
        return haspath(graph,source,destination,visited);
        
    }
    
    public boolean haspath(ArrayList<Integer> [] graph,int source,int destination,boolean []visited){
        if(source==destination)
            return true;
        
        visited[source]=true;
        for(int it : graph[source]){
            if(visited[it]==false){
                boolean check=haspath(graph,it,destination,visited);
                
                if(check==true){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
public boolean validPath(int n, int[][] edges, int source, int destination){
    
    ArrayList<Integer>[] graph=new ArrayList[n];
    for(int i =0 ;i<n;i++){
    graph[i] = new ArrayList<>();
     }

    for(int [] edge : edges){
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
    }
    boolean[] visited=new boolean[n];
    return hasPath(graph,source,destination,visited);
    
}

private static boolean hasPath(ArrayList<Integer>[] graph,int source, int destination,boolean[] visited){
    if(source==destination) return true;
    
    visited[source]=true;
    for(int nbr : graph[source]){
        //System.out.println(nbr);
        if(visited[nbr]==false){
        boolean hasnebrPath=hasPath(graph,nbr,destination,visited);
        if(hasnebrPath==true){
            return true;
        }
        }
    }
    return false;
}*/
    
    
    