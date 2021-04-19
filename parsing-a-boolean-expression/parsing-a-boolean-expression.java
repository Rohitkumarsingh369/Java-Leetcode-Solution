class Solution {
    public boolean parseBoolExpr(String expression) {
    return eval(expression, new int[1]);
}

private boolean eval(String expression, int[] idx) {
    var c = expression.charAt(idx[0]++);
    if (c=='t') return true;
    if (c=='f') return false;
    if (c=='!') {
        idx[0]++;
        var val = eval(expression,idx);
        idx[0]++;
        return !val;
    } else {
        idx[0]++;
        var val = c=='&';
        while(expression.charAt(idx[0])!=')') {
            var res = eval(expression,idx);
            if (c=='&') {
                val&=res;
            } else {
                val|=res;
            }
            if (expression.charAt(idx[0])==',') idx[0]++;
        }
        idx[0]++;
        return val;
    }
}
}