class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0, tempSum = 0, count = 0;
        for (int i: arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (tempSum == sum / 3) {
                tempSum = 0;
                count++;
                if (count == 3) {
                    break;
                }
            }
        }

        return count == 3;
    }
}