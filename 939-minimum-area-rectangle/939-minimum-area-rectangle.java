class Solution {
    public int minAreaRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        HashSet<Pair<Integer,Integer>> visited = new HashSet();
        for(int[] point1:points){
            int x1 = point1[0];
            int y1 = point1[1];
            for(Pair<Integer,Integer> point2:visited){
                int x2 = point2.getKey();
                int y2 = point2.getValue();
                if(visited.contains(new Pair(x1, y2)) && 
                   visited.contains(new Pair(x2, y1)))
                {
                    result = Math.min(Math.abs(x1 - x2) * Math.abs(y1-y2),result);
                }
            }
            visited.add(new Pair(x1, y1));
        }
        
        return result == Integer.MAX_VALUE?0:result;
    }
}