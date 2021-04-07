class Solution {
    public int findDuplicate(int[] arr) {
        int result=0;
        for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] > 0) {
			arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
			else {
			result=(Math.abs(arr[i]));
			}
		}
         return result;    
    }
   
}