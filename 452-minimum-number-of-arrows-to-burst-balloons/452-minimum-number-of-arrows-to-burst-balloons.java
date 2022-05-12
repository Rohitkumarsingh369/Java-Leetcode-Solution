class Solution {
    public int findMinArrowShots(int[][] points) {
         Arrays.sort(points, (a,b) -> a[1] - b[1]);
        int i = 0;
        int minarrows = 0;
        while(i < points.length){
            int j = i + 1;
            while(j < points.length && points[i][1] >= points[j][0] && points[i][1] <= points[j][1]){
                j++;
            }
            i = j;
            minarrows++;
        }
        return minarrows;
    }
}