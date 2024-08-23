class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0;  // Josephus problem result for n = 1
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1; // Convert 0-based index to 1-based index
    }
}