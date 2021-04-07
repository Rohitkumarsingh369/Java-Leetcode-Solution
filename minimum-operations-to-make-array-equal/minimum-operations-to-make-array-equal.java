class Solution {
    public int minOperations(int n) {
        
        // 1  3  5  7  9 arr[i]
        // 0  1  2  3  4
        // n = 5, half =  5 / 2 = 2
        
        //sum =  (5 - 1) +  (5 - 3) 
        //.   =  (5 + 5) -  (1 + 3)
        //.   =  (n * 2) -  (sum of first n / 2  odd number)
        
        int half = (n / 2);
        
        return (n * half) - getSeriesSum(1, 2, half);
    }
                                
    private int getSeriesSum(int a, int d, double n){
        //Arithmetic Progressions
        //The sum to n terms of an arithmetic progression
        //This is given by:
        //Sn = ½ n [ 2a + (n - 1)d ]
        //  where d = common difference, a = first term
        
        
        return (int)((n / 2) * (2 * a + (n - 1)  * d));
    }   
}