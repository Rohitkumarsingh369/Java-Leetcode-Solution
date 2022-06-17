class Solution {
   /* public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];
        ArrayList<Integer> sorted = new ArrayList<>();
		//Counting soldiers
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            soldiers[i] = count;
			//This is simply to set default values
            sorted.add(i);
        }
        
		//Sorting ArrayList
       for (int i = 1; i < soldiers.length; i++) {
            int append = i;
            for (int j = i - 1; j >= 0; j--) {
                if (soldiers[i] < soldiers[j]) {
                    append--;
                }
            }
           
            sorted.remove(i);
            sorted.add(append, i);
        }
        
       // Collections.sort(sorted);
		//Getting k values from sorted
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = sorted.get(i);
        }
        return result;
    }*/
    

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }
        
        while (k > 0)
            ans[--k] = pq.poll()[1];
        
        return ans;
    }
    
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
}