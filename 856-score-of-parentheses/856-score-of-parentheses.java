class Solution {
    public int scoreOfParentheses(String str) {
        Stack<String> s=new Stack<>();
		
		int i=0;
		int ans=0;
		while(i<str.length()) {
			if(str.charAt(i)=='(')
				s.add("(");
			else {
				if(s.peek()=="(")
				{
					s.pop();
					s.add("1");
				}
				else {
					int count=0;
					while(s.peek()!="(") {
						count+=Integer.parseInt(s.peek());
						s.pop();
					}
					s.pop();
					s.add(String.valueOf(2*count));
				}
			}
			i++;
		}
		while(!s.empty()) {
			ans+=Integer.parseInt(s.peek());
			s.pop();
		}
		return  ans;
    }
}