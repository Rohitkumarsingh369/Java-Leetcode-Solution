class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // If the city i is not visited, it starts a new province
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                // If there is a direct connection and the city j is not visited
                dfs(isConnected, visited, j);
            }
        }
    }
}