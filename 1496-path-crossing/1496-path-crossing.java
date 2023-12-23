class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, int[]> dir= new HashMap();
        dir.put('N', new int[]{0,1});
        dir.put('S', new int[]{0,-1});
        dir.put('E', new int[]{1,0});
        dir.put('W', new int[]{-1,0});
        Set<String> visited= new HashSet();
        int x =0, y =0;
        visited.add(new String(x+"#"+y));
        for(char c: path.toCharArray()){
            int[] d = dir.get(c);
            int newX=x+d[0];
            int newY=y+d[1];
            String point=newX+"#"+newY;
            if (visited.contains(point)){
                return true;
            }else{
                x=newX;
                y=newY;
                visited.add(point);
            }
        }
        return false;
    }
}