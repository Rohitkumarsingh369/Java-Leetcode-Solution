class Solution {
    public String removeDuplicateLetters(String s) {
        int lastIndex[]=new int[26];
        
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        
        boolean visited[]=new boolean [26];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            
            if(visited[x]) continue;
            
            while(stack.size()!=0 && stack.peek()>x && lastIndex[stack.peek()]>i){
                visited[stack.pop()]=false;
            }
            
            stack.push(x);
            visited[x]=true;
        }
        StringBuilder str=new StringBuilder();
        
        while(stack.size()!=0){
            str.append((char)(stack.pop()+'a'));
        }
        return str.reverse().toString();               
    }
}