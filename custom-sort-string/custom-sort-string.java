class Solution {
    public String customSortString(String order, String str) {
	StringBuffer buff = new StringBuffer();
	int[] arr = new int[26];
	for(int i = 0; i<str.length();i++){arr[str.charAt(i) - 'a']++;}
	for(int i = 0; i<order.length();i++){
		while(arr[order.charAt(i) - 'a']-->0){ buff.append(order.charAt(i)); }
	}
	for(int i = 0; i<26;i++){ 
		while(arr[i]-- > 0){ buff.append((char)(i + 'a'));}
	}
	return buff.toString();
}
}
