class Solution {
   static HashMap<Character, Integer> balloonChars = new HashMap();
    static {
        balloonChars.put('b', 1);
        balloonChars.put('a', 1);
        balloonChars.put('l', 2);
        balloonChars.put('o', 2);
        balloonChars.put('n', 1);
        
    }

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : text.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int result = Integer.MAX_VALUE;
        
        for (char c : balloonChars.keySet()) {
            if (!map.containsKey(c)) return 0;
            
            result = Math.min(result, (int) map.get(c)/balloonChars.get(c));
        }
        
        return result;
    }
}