class Solution {
    public String restoreString(String s, int[] indices) {
         int n = s.length();
        char arr[] = new char[n];
        
        for(int i=0; i<n; i++){
            arr[indices[i]]= s.charAt(i);
        }
        String ans = new String(arr);
        return ans;
    }
}