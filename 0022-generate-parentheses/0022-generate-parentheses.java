class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        helper(result,"",n,n);
        return result;
    }
    public static void helper(List<String> result,String current, int open, int close){
        if(open==0 && close==0){
            result.add(current);
            return;
        }
        
        if(open>0){
            helper(result,current+"(",open-1,close);
        }
        
        if(close>open){
            helper(result,current+")",open,close-1);
        }
    }
}