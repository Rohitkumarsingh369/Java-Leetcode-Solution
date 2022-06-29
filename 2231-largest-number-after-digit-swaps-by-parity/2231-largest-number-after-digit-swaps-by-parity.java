class Solution {
    public int largestInteger(int num) {
       PriorityQueue<Integer> evenPq = new PriorityQueue<>();
		PriorityQueue<Integer> oddPq = new PriorityQueue<>();
		int ref = num;
		while ( num > 0 ) {
			int right = num % 10;
			if ( right % 2 == 1 ) {
				oddPq.offer(right);
			} else {
				evenPq.offer(right);
			}
			num /= 10;
		}
		int num2 = 0;
        int mul = 1;
        
		while ( ref > 0 ) {
            int cur = ref % 10;
			if ( cur % 2 == 1 ) {
				num2 = oddPq.poll() * mul + num2;
			} else {
                num2 = evenPq.poll() * mul + num2;
			}
			ref /= 10;
            mul *= 10;
		}
		return num2;
    }
}