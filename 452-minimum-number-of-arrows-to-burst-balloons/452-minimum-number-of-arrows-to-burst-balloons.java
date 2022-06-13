class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
 
        // Initialize end variable with
        // the end of first balloon
        int end = points[0][1];
 
        // Initialize arrow with 1
        int arrow = 1;
 
        // Iterate through the entire
        // arrow of points
        for (int i = 1; i < points.length; i++) {
 
            // If the start of ith balloon
            // <= end than do nothing
            if (points[i][0] <= end) {
                continue;
            }
 
            // if start of the next balloon
            // >= end of the first balloon
            // then increment the arrow
            else {
 
                // Update the new end
                end = points[i][1];
                arrow++;
            }
        }
 
        // Return the total count of arrows
        return arrow;
    }
}