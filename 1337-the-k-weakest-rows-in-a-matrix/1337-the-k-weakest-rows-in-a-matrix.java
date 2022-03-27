class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
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
    }
    
}