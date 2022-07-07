class Solution {
    public int findCenter(int[][] e) {
        //here first is referred to ui of [ui,vi]
   //here second is referred to vi of [ui,vi] 
    
   /* int first=edges[0][0];
    int second=edges[0][1];
    
    int first_count=0;
    int second_count=0;
    
    for(int i=1;i<edges.length;i++ ){
        if(edges[i][0]==first || edges[i][1]==first){
               first_count++;
        }
        else if(edges[i][0]==second || edges[i][1]==second){
        second_count++;
        }
            
    }
 
          return first_count>second_count ? first : second;*/
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    
    }
    
}