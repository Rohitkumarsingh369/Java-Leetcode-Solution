class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> valueIndex = new HashMap();
        int len = arr.length;
        //put indexes w.r.t. value in map
        for(int i=0;i<len;i++){
            valueIndex.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
        }
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList();
        //starting from 0 index
        queue.add(0);
        //marking visited to 0 index
        visited[0] = true;
        int jumps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int idx = queue.poll();
                //finding adjency list, if a value if available in more than 1 index then this will to go to next index directly
                //check if it reachs the end
                if(idx == len-1)
                    return jumps;
                List<Integer> adjList = valueIndex.get(arr[idx]);
                //plus we can move to idx+1 & idx-1
                adjList.add(idx+1);
                adjList.add(idx-1);
                //traversing the adjency list, putting the valid indexes in queue for further processing
                for(int j : adjList){
                    if(j>= 0 && j < len && !visited[j]){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                adjList.clear();
            }
            jumps++;
        }
        return -1;
    }
}