class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int colwidth=grid[0].length;
        int rowheight=grid.length;
        
        int modulo=(colwidth*rowheight);
        int finalindex[]=new int[modulo];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int index=((i*colwidth)+j+k)%modulo;
                
                finalindex[index]=grid[i][j];
                
            }
        }
        List<List<Integer>> resultList=new ArrayList<>();
        
        for(int i=0;i<rowheight;i++){
            resultList.add(new ArrayList<>());
        }
        int counter = 0;
        int rowCount = -1;
        
        for(int i = 0; i < finalindex.length; i++){
            if(i % colwidth == 0){
                rowCount++; 
            }    
            //add to the row where it belongs    
            resultList.get(rowCount).add(finalindex[i]);
        }
        
        // the answer
        return resultList;
    }
    
}