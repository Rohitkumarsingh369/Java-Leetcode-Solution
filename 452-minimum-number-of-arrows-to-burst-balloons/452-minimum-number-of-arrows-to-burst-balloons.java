class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort( points , (a , b) -> ( Integer.compare(a[0] , b[0] ) ) );
        int st = points[0][0] , en = points[0][1];
        int cnt = 1;
        for(int i=1 ;i < points.length ;i++){
            
            if(points[i][0] > en ){
                
                cnt++;
                st  = points[i][0];
                en  = points[i][1];
            }
            else {
                
                st = Math.max(st , points[i][0]);
                en = Math.min(en , points[i][1]);
            }
        }
        
        return cnt;
    }
}