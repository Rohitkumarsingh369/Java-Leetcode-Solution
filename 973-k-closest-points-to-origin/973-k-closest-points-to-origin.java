class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int length=points.length;
        int result[][]=new int[k][2];
        
        int distance[]=new int[length];
        for(int i=0;i<length;i++){
            int x=points[i][0];
            int y=points[i][1];
            distance[i]=(x*x)+(y*y);
        }
        Arrays.sort(distance);
        int distancek=distance[k-1];
        
        int index=0;
        for(int i=0;i<length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=(x*x)+(y*y);
            if(dist<=distancek){
                result[index][0]=x;
                result[index][1]=y;
                index++;
            }
        }
        return result;
    }
}