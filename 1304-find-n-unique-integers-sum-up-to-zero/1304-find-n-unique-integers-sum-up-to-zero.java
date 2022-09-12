class Solution {
    public int[] sumZero(int n) {
        int[] soln=new int[n]; 
		soln[n/2]=0; //middle element
        for(int i=0;i<n/2;i++){
            soln[i]=i+1;  //element from start
			soln[n-1-i]=-(soln[i]); //element from end
        }
        return soln;
    }
}