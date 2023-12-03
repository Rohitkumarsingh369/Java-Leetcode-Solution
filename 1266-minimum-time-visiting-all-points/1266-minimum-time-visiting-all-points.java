class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
         int res = 0;
        for(int i =0, j = 1; i < points.length - 1; i++, j++) 
            res += Math.max(Math.abs(points[j][0] - points[i][0]) , Math.abs(points[j][1] - points[i][1]));
        
        return res;
    }
}