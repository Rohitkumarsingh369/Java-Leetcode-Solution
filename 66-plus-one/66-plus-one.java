class Solution {
    public int[] plusOne(int[] digits) {
        
		// Form the first element (right most element) by summing up with 1
		// Also take note of the carry for next iteration.
        int sum = digits[digits.length-1]+1;
        int carry = sum/10;
        digits[digits.length-1] = sum % 10;

       //start from digits.length-2 since last position is already handled. 
	   // Do the same step by calculating the carry  and updating the array.
        for(int i=digits.length-2;i>=0;i--){
            sum = digits[i]+carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
		//This is to cover the edge case where carry exists after whole execution.
		//Note that we need to expand the array to accomodate this carry
        if(carry > 0){
            int[] newDigits = new int[digits.length+1];
			//simply copy everything from digits array
            for(int i=digits.length-1; i>=0 ; i--){
			   // i'th element in digits array would be i+1'th element in new array. 
                newDigits[i+1] = digits[i];
            }
			//Just copy the carry to first element.
            newDigits[0]=carry;
            digits=newDigits;
        }
        return digits;
    }
}