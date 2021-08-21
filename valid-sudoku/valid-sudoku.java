class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] filled = new boolean[10][3][10];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int charIndex = board[i][j] - '0';
                int index = getBoxIndex(i, j);
                if(filled[charIndex][0][i] || 
                   filled[charIndex][1][j] || 
                   filled[charIndex][2][index]) return false;
                filled[charIndex][0][i] = true;
                filled[charIndex][1][j] = true;
                filled[charIndex][2][index] = true;
            }
        }
        
        return true;
    }
    
    private int getBoxIndex(int i, int j) {
        return (i/3)*3 + (j/3);
    }
}