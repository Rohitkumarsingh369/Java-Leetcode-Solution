class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int sumfront = 0;
    int sumback = 0;
    int max = 0;
    
    int front = 0,back = cardPoints.length-1;
    
    for(int i =0;i<k;i++){ //get sum of just the front
        sumfront += cardPoints[front++];
    }
    max = sumfront; //put front sum as max
	
    for(int i=0;i<k;i++){ //get sum of (back + front) sum one by one
        sumback += cardPoints[back--];
        sumfront -= cardPoints[--front];
        max = Math.max(max,sumback+sumfront); //check for max
    }
    
    return max;
    
}
}