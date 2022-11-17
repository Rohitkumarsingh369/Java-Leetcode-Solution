class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculating Area Of A and B
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        
        // Calculating The Left Boundary
        int left_boundary = Math.max(ax1, bx1);
        
        // Calculating The Right Boundary
        int right_boundary = Math.min(bx2, ax2);
        
        // Calculating The Up Boundary
        int upper_boundary = Math.min(by2, ay2);
        
        // Calculating The Down Boundary
        int lower_boundary = Math.max(ay1, by1);
        
        // Total Area
        int totalArea = areaA + areaB;
        
        // If Both Reactangle Overlaps
        if(right_boundary > left_boundary && upper_boundary > lower_boundary) totalArea -= ((right_boundary - left_boundary) * (upper_boundary - lower_boundary));
        
        return totalArea;
    }
}