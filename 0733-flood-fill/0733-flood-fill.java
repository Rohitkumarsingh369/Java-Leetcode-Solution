class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int oldColor=image[sr][sc];
        
        if(oldColor==newColor){
            return image;
        }
        
        int rows=image.length;
        int cols=image[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        
        queue.offer(new int[]{sr,sc});
        image[sr][sc]=newColor;
        
        int [][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int [] pixel=queue.poll();
            
            int row=pixel[0];
            int col=pixel[1];
            
            for(int [] direction :directions){
                int nr=row+direction[0];
                int nc=col+direction[1];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && image[nr][nc]==oldColor){
                    image[nr][nc]=newColor;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}