class Solution 
{
    List<String> a = new ArrayList<>();
    String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
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
    }
}