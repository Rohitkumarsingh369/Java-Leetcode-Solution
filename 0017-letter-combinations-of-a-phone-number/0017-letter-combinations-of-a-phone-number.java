class Solution 
{
    List<String> result = new ArrayList<>();
    String mapping[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    /*public List<String> letterCombinations(String digits) 
    {
        if(digits.equals(""))
            return a;
        func(0,new StringBuilder(""),digits);
        return a;
    }
    
    void func(int index,StringBuilder s,String digits)
    {
        if(s.length()==digits.length())
        {
            a.add(new String(s));
            return;
        }
        int a = digits.charAt(index) - '0';
        for(int i=0;i<arr[a].length();i++)
        {
            s.append((arr[a].charAt(i)));
            func(index+1,s,digits);
            s.deleteCharAt(s.length()-1);
        }
    }*/
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return result;
        dfs(0,digits,new StringBuilder());
        return result;
    }
    
    void dfs(int length,String digits, StringBuilder temp){
        if(length==digits.length()){
            result.add(temp.toString());
            return;
        }
        
        char ch=digits.charAt(length);
        String str=mapping[ch-'0'];
        for(char c:str.toCharArray()){
            temp.append(c);
            dfs(length+1,digits,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}