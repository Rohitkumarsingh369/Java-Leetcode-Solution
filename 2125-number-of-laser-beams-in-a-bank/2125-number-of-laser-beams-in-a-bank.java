class Solution {
    public int numberOfBeams(String[] bank) {
        int total = 0;
        int prev = 0;
        for(String row : bank){
            int curr = 0;
            for(int i=0; i < row.length(); i++){
                if(row.charAt(i) == '1'){
                    curr++;
                }
            }
            if(curr > 0){
                total += (prev * curr);
                prev = curr;
            }
        }
        return total;
    }
}