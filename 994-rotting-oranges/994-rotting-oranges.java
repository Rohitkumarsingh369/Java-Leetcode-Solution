class Solution {
    
	// Class to just hold the coordinates which will help in navigation in all 4 directions
        public  class Pair {
        int x = 0;
        int y = 0;

        Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
        }
            
    public int orangesRotting(int[][] grid) {
         int times = 0;
            Queue<Pair> queue = new LinkedList<>();
            int total = 0;
            int rotten = 0;
			// get total oranges and fill the queue with rotten oranges
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 || grid[i][j] == 2) {
                        total++;
                    }
                    if (grid[i][j] == 2) {
                        queue.add(new Pair(i, j));
                    }
                }
            }
			// if no oranges, then return 0
            if (total == 0) {
                return 0;
            }

			// start bfs
            while (!queue.isEmpty()) {
                int size = queue.size();
				// rotten initially will be equal to size of the queue as we have flled queue with rotten oranges
                rotten += size;
				// if total oranges and rotten oranges are equal, then it means we need to send the number of minutes it took for all the oranges to get rotten
                if (total == rotten) {
                    return times;
                }
				// incrementing minutes
                times++;
				
				// Running a loop here for all the elemenets in queue, so that the elements rotten in other directions by multiple starting point of rotten oranges
                for (int i = 0; i < size; i++) {
                    Pair p = queue.poll();
					// check in all 4 directions and if fresh orange exists, convert it to a rotten orange and then add it to queue for next iteration
                    if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                        grid[p.x + 1][p.y] = 2;
                        queue.add(new Pair(p.x + 1, p.y));
                    }
                    if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                        grid[p.x][p.y + 1] = 2;
                        queue.add(new Pair(p.x, p.y + 1));
                    }
                    if (p.x - 1 >=0 && grid[p.x - 1][p.y] == 1) {
                        grid[p.x - 1][p.y] = 2;
                        queue.add(new Pair(p.x - 1, p.y));
                    }
                    if (p.y - 1 >=0 && grid[p.x][p.y - 1] == 1) {
                        grid[p.x][p.y - 1] = 2;
                        queue.add(new Pair(p.x, p.y - 1));
                    }
                }
            }
			// return -1 if some fresh oranges are left
            return -1;
    }

    
}