class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (digits == null || digits.length == 0) {
            int[] temp = {1};
            return temp;
        }
         
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                carry = carry + digits[i] + 1;
            } else {
                carry += digits[i];
            }
            result.add(0, carry % 10);
            carry /= 10;
        }
         
        if (carry == 1) {
            result.add(0, 1);
        }
        int resultArray[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
         
        return resultArray;
    }
}