class Solution {
   private int pos = 0;
    public String decodeString(String s) {
    	/*int n = s.length(), repeat = 0;
    	StringBuilder buf = new StringBuilder();
    	while (pos < n) {
    		char c = s.charAt(pos);
    		if (c >= 'a' && c <= 'z') {
    			buf.append(c);
    		} else if (c >= '0' && c <= '9') {
    			repeat = repeat * 10 + (c - '0');
    		} else if (c == '[') {
    			pos++;  // skip the char '['
    			String str = decodeString(s);  // pos is diff for each call
    			for (int i = 0; i < repeat; i++)
   					buf.append(str);
    			repeat = 0;  // reset the value for the next input
    		} else if (c == ']')
    			break;
    		pos++;
    	}
    	return buf.toString();*/
        Stack<Character> st=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c!=']'){
                st.push(c);
            }
            else{
                StringBuilder sb=new StringBuilder();
                
                while(!st.isEmpty() && Character.isLetter(st.peek()))
                        sb.insert(0,st.pop());
                
                String letter=sb.toString();
                
                st.pop();
                
                sb.setLength(0);
                while(!st.isEmpty() && Character.isDigit(st.peek()))
                        sb.insert(0,st.pop());
                
                int count=Integer.valueOf(sb.toString());
                
                while(count>0){
                    for(char ch:letter.toCharArray())
                        st.push(ch);
                    count--;
                }
            }
        }
        
        StringBuilder result=new StringBuilder();
        while(!st.isEmpty()){
            result.insert(0,st.pop());
        }
        return result.toString();
    }
}