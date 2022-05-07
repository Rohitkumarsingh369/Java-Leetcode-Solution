class Solution {
    int[] dx = {1 , 0 , -1 , 0};
    int[] dy = {0 , 1 , 0 , -1};
    HashMap<Integer , Integer> map;
    int islandNo;
    int len;
    ArrayList<Integer> count;
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        islandNo = 0;
        map = new HashMap<>();
        count = new ArrayList<>();
        int[][] visited = new int[n][n];

        for (int i= 0 ; i< n ; i++){
            for(int j = 0; j< n ; j++){
                if (visited[i][j] == 0 && grid[i][j] == 1){
                    len = 0;
                    solve(grid , i , j , visited,  n);
                    count.add(len);
                    islandNo++;
                }
            }
        }

        int max = 0;

        for (int i =0 ; i< n ; i++){
            for (int j =0; j< n ; j++){
                if (grid[i][j] == 0){
                    int sum = 1;
                    HashSet<Integer> isPresent = new HashSet<>();
                    for (int k =0; k < 4 ; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                            continue;
                        }
                        int mask = nx * 1000 + ny;
                        int ind = map.getOrDefault(mask , -1);
                        if (ind != -1 && !isPresent.contains(ind)){
                            sum += count.get(ind);
                            isPresent.add(ind);
                        }
                    }

                    max = Math.max(max , sum);
                }
            }
        }

        if (max == 0){
            for (int num : count){
                max = Math.max(max , num);
            }
        }
        
        return max == 0 ? 1 : max;

    }


    void solve(int[][] grid , int x , int y , int[][] visited, int n){
        visited[x][y] = 1;
        int mask = x*1000 + y;
        map.put(mask , islandNo);
        len++;

        for(int i = 0; i< 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (visited[nx][ny] == 0 && grid[nx][ny] == 1){
                solve(grid , nx , ny , visited , n);
            }
        }

    }   
}