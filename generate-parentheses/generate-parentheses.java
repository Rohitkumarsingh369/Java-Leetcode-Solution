class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        StringBuilder temp = new StringBuilder();
        genP(n,n,temp,res);
        return res;
    }
    
    private void genP(int o, int c, StringBuilder temp, List<String> res){
        if(c+o==0){
            res.add(temp.toString());
            return;
        }
        if(o==c){
            temp.append("(");
            genP(o-1,c,temp,res);
        }
        else if(o==0 && c!=0){
            temp.append(")");
            genP(o,c-1,temp,res);
        }
        else{
            StringBuilder op1 = new StringBuilder(temp);
            StringBuilder op2 = new StringBuilder(temp);
            op1.append("(");
            op2.append(")");
            genP(o-1,c,op1,res);
            genP(o,c-1,op2,res);
        }
    }
}