class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        for(int i:asteroids)
        {
            if(s.empty() || i>0 )
            {
                s.push(i);
            }
            else
            {
                boolean destroyed = false;
                while(!s.empty() && s.peek()>0)
                {
                    int tp = s.peek();
                    if(Math.abs(i) > tp)
                    {
                        s.pop();
                    }
                    else if(Math.abs(i) < tp)
                    {
                        destroyed = true;
                        break;
                    }
                    else
                    {
                        s.pop();
                        destroyed = true;
                        break;
                    }
                }
                if(destroyed==false)
                {
                    s.push(i);
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