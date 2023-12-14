class Solution {
   public int[][] onesMinusZeros(int[][] inputGrid) {
    int[] rowSumOnes = new int[inputGrid.length];
    int[] colSumOnes = new int[inputGrid[0].length];
    
    // Calculate the sum of ones for each row and column
    for (int i = 0; i < inputGrid.length; i++) {
        for (int j = 0; j < inputGrid[0].length; j++) {
            rowSumOnes[i] += inputGrid[i][j];
            colSumOnes[j] += inputGrid[i][j];
        }
    }

    // Calculate the difference between twice the sum of ones and the grid dimensions
    for (int i = 0; i < inputGrid.length; i++) {
        for (int j = 0; j < inputGrid[0].length; j++) {
            inputGrid[i][j] = 2 * (rowSumOnes[i] + colSumOnes[j]) - inputGrid.length - inputGrid[0].length;
        }
    }

    return inputGrid;
}

}