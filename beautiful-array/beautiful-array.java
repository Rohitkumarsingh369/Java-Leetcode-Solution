class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        
        while(list.size() < n){
            ArrayList<Integer> temp = new ArrayList();
            
            for(int el : list){
                if(2 * el - 1 <= n){
                    temp.add(2*el - 1);
                }
            }
            
            for(int el : list){
                if(2 * el <= n){
                    temp.add(2*el);
                }
            }
            list = temp;
        }
        
        int[] res = new int[n];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}