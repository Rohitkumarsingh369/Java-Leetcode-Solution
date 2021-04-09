class Solution {
    ArrayList<String> list;
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list=new ArrayList<>();
        if(digits.length()==0)
            return list;
       String[] table
			= { "0", "1", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz" };
		char c[]=digits.toCharArray();
		 list= letterCombinationsUtil(c, digits.length(), table);
        
        return list;
    }
    static ArrayList<String>letterCombinationsUtil(char [] number, int n,String[] table)
	{
		// To store the generated letter combinations
		ArrayList<String> list = new ArrayList<>();

		Queue<String> q = new LinkedList<>();
		q.add("");

		while (!q.isEmpty()) {
			String s = q.remove();
				//System.out.println("o/p :"+s);
				//System.out.println("length :"+s.length());
			// If complete word is generated
			// push it in the list
			if (s.length() == n)
				list.add(s);
			else {
				String val = table[number[s.length()]-'0'];
				for (int i = 0; i < val.length(); i++)
				{
					q.add(s + val.charAt(i));
				}
			}
		}
		return list;
	}
}