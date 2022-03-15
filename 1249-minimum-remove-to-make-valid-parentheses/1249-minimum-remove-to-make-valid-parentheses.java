class Solution {
    public String minRemoveToMakeValid(String s) {
        
       int count = 0;
        
        char ch[] = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(') count++;
            else if(ch[i] == ')'){
                if(count == 0) ch[i] = '#';
                else count--;
            }
        }
        
        for(int i = ch.length - 1; i >= 0; i--){
            if(ch[i] == '(' && count > 0){
                ch[i] = '#';
                count--;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != '#') sb.append(ch[i]);
        }
        return sb.toString();
    }
}