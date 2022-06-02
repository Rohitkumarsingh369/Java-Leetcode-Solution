class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] position = new int[]{0,0};
        int direction = 0; //0 = Up; 1 = Right; 2 = Down; 3 = Left
          
            for(Character c: instructions.toCharArray())
            {
                
                if(c=='G')
                {
                    position[0]+=directions[direction][0];
                    position[1]+=directions[direction][1];
                }
                else
                {
                    if(c=='L')
                    {
                        direction = Math.abs((4+direction-1)%4);
                    }
                    else
                    {
                        direction = (direction+1)%4;
                    }
                }
                
            }
            
                 
        if((position[0]==0 && position[1]==0) ||direction!=0)
        {
            return true;
        }
        
        return false;
    }
}