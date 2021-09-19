class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperators(num, target, result, 0, 0, 0, "");
        return result;
    }
    
    private void addOperators(String num, int target, List<String> result, int index, long value, long previous, String current) {
        if(index == num.length()) {
            if(value + previous == target) {
                result.add(current);
            }
            return;
        }
        
        int end = num.length();
        if(num.charAt(index) == '0') {
            end = index + 1;
        }
        
        for(int i = index + 1; i <= end; i ++) {
            long currentValue = Long.valueOf(num.substring(index, i));
            
            if(index == 0) {
                addOperators(num, target, result, i, 0, currentValue, String.valueOf(currentValue));
                continue;
            } 
            
            // Add +
            addOperators(num, target, result, i, value + previous, currentValue, current + "+" + currentValue);
            // Add -
            addOperators(num, target, result, i, value + previous, -currentValue, current + "-" + currentValue);
            // Add *
            addOperators(num, target, result, i, value, previous * currentValue, current + "*" + currentValue);
        }
    }
}