class Solution {
    public int countSubstrings(String s) {
        int result = 0;
		
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++) {
            	    if(s.substring(i, j).equalsIgnoreCase(new StringBuilder().append(s.substring(i, j)).reverse().toString())) {
            		result++;
            	}
            }
        }
        
        return result;
    }
}