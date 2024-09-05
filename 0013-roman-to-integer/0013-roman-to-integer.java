class Solution {
    public int romanToInt(String s) {
        // Step 1: Map Roman numerals to their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        // Step 2: Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // Step 3: If the current value is greater than the previous one, we subtract twice the previous value
            if (currentValue > prevValue) {
                total += currentValue - 2 * prevValue;  // Undo previous addition and subtract it
            } else {
                total += currentValue;
            }

            // Step 4: Update the previous value to current value
            prevValue = currentValue;
        }

        return total;
    }
}