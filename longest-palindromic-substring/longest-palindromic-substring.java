class Solution {
    public String longestPalindrome(String str) {
        int maxlength=1;
		int start=0;
		int len=str.length();
		int low,high;
		
		
		for(int i=1;i<len;i++) {
			//even
			low=i-1;
			high=i;
			
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)) {
				if(high-low+1>maxlength) {
					start=low;
					maxlength=high-low+1;
				}
				--low;
				++high;
			}
			
			//odd
			low=i-1;
			high=i+1;
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)) {
				if(high-low+1>maxlength) {
					start=low;
					maxlength=high-low+1;
				}
				--low;
				++high;
			}
		}
		
		return(printsubstring(str,start,(start+maxlength-1)));
		
    }
    public static String printsubstring(String str,int low,int high) {
		String result=str.substring(low,high+1);
		return result;
	}
}