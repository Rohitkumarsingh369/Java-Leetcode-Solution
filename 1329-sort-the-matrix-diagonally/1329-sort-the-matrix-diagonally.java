class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length;
		int col=mat[0].length;
		
		for(int i=0;i<row+col;i++) {
			int r=0,c=i;
			if(i>col) {
				r=i-col;
				c=0;
			}
			int size=Math.min(row-r,col-c);
			int arr[]=new int[size];
			for(int d=0;d<size;d++) {
				arr[d]=mat[r+d][c+d];
			}
			Arrays.sort(arr);
			
			for(int d=0;d<size;d++) {
				mat[r+d][c+d]=arr[d];
			}
			
		}
        return mat;
    }
}