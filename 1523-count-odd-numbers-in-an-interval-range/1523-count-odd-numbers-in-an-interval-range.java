class Solution {
    public int countOdds(int low, int high) {
         int total = high - low + 1;
        if(total % 2 == 0)
            return total / 2;
        else {
            if(low % 2 != 0)
                return total/2 + 1;
            else 
                return total/2;
        }
    }
}