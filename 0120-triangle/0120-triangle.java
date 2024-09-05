class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         if (triangle == null || triangle.isEmpty()) return 0;

        int n = triangle.size();
        
        // Starting from the second-to-last row, moving up to the top
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);

            // Update each cell with the minimum path sum from that cell to the bottom
            for (int j = 0; j <= i; j++) {
                int minPathSum = Math.min(nextRow.get(j), nextRow.get(j + 1));
                currentRow.set(j, currentRow.get(j) + minPathSum);
            }
        }
        
        // The top cell now contains the minimum path sum
        return triangle.get(0).get(0);
    }
}