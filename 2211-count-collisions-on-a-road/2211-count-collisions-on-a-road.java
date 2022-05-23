class Solution {
    public int countCollisions(String dir) {
       int res = 0, n = dir.length(), i = 0, carsFromRight = 0;
        
        while (i < n && dir.charAt(i) == 'L') i++;
        
        for ( ; i<n; i++) {
            if (dir.charAt(i) == 'R')  carsFromRight++;
            else {
                res += (dir.charAt(i) == 'S') ? carsFromRight : carsFromRight+1;
                carsFromRight = 0;
            }
        }
        return res; 
    }
}