class Solution {
    public int findMinArrowShots(int[][] points) {
         if(points.length == 0) return 0;  
     int n = points.length;  
     Arrays.sort(points, (a, b)->{  
       if(a[0] == b[0]) return Integer.compare(a[1],b[1]);  
       return Integer.compare(a[0],b[0]);  
     });  
     int p1 = 0;  
     int ans = 1;  
     // point 0's end    
     int end = points[0][1];  
     for(int i = 1; i < n; i++){  
       //when end is smaller than next start, we need another arrow  
       //we need to update end, if end is smaller than previous ones  
       end = Math.min(end,points[i][1]);  
       if( end < points[i][0]){  
         end = points[i][1];  
         ans++;  
       }  
     }  
     return ans;
    }
}