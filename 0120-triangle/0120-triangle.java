class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        if (n == 0)
            return 0;
        
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            
            for (int j = 0; j < currentRow.size(); j++) {
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + currentRow.get(j);
                currentRow.set(j, sum);
            }
        }
        
        return triangle.get(0).get(0);
    }
}
