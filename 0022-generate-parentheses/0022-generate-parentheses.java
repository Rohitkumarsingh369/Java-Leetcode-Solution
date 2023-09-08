class Solution {
   /* public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
      
        StringBuilder sb = new StringBuilder();
        backTracking(result, sb, 0, 0, n);
        
        return result;
    }
    
    private void backTracking(List<String> result, StringBuilder sb, int open, int close, int n) {
        if(open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        
        if(open < n) {
            sb.append("(");
            backTracking(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(open > close) {
            sb.append(")");
            backTracking(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }*/
    
    public List<String> generateParenthesis(int n){
        List<String> result=new ArrayList<>();
        
        StringBuilder sb=new StringBuilder();
        
        backtracking(result,sb,0,0,n);
        
        return result;
    }
    
    public void backtracking(List<String> result,StringBuilder sb,int open,int close,int length){
        if(open==length && close==length){
            result.add(sb.toString());
        }
        
        if(open<length){
            sb.append("(");
            backtracking(result,sb,open+1,close,length);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(open>close){
             sb.append(")");
            backtracking(result,sb,open,close+1,length);
             sb.deleteCharAt(sb.length()-1);
        }
    }
}