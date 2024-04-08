class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        for(int ast:asteroids)
        {
            
            if(ast>0){
                s.push(ast);
            }
            else{
                
                while(s.size()>0 && s.peek()>0 && s.peek()<-ast){
                    s.pop();
                }
                
                if(s.size()>0 && s.peek()==-ast){
                    s.pop();
                }
                else if(s.isEmpty() || s.peek()<0){
                    //do nothing
                    s.push(ast);
                }
                  
            }
            
        }
        
        int[] ans = new int[s.size()];
        for(int i=s.size()-1; i>=0; i--)
        {
            ans[i] = s.peek();
            s.pop();
        }
        return ans;
        
    }
}