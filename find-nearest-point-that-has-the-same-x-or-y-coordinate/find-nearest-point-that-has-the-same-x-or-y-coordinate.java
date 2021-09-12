class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int min=Integer.MAX_VALUE;
        int index=-1;
        int length=points.length;
        for(int i=0;i<length;i++){
            int xx=points[i][0];
            int yy=points[i][1];
            if(xx==x||yy==y){
                int dist=Math.abs(xx-x)+Math.abs(yy-y);
                if(min>dist){
                    min=dist;
                    index=i;
                }
            }
        }
        return index;
    }
}