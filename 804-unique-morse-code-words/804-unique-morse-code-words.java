class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] str = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		HashSet<String> set = new HashSet<>();
		for (String i: words){
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i.length(); j ++){
				int c = i.charAt(j);
				sb.append(str[c - 97]);
			}
			set.add(String.valueOf(sb));
		}
		return set.size();
    }
}