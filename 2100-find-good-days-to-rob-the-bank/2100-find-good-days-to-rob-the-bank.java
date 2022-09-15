class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new LinkedList();
        int[] increasing = new int[security.length];
        int[] decreasing = new int[security.length];
        for(int i = 1; i < security.length; i++)
        {
            if(security[i-1] >= security[i])
                decreasing[i] = decreasing[i-1] + 1;                 
        }
        
        for(int i = security.length - 2; i > -1; i--)
        {
            if(security[i+1] >= security[i])
                increasing[i] = increasing[i+1] + 1;                
        }
        for(int i = 0; i < security.length; i++)
        {
            if(increasing[i] >= time && decreasing[i] >= time)
                ans.add(i);
            
        }
        return ans;
    }
}