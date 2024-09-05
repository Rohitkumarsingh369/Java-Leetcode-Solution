class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // Sort characters in the string
            String sortedStr = new String(chars); // Convert sorted characters back to string
            
            // If the key is not present in the map, add it with a new list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // Add the original string to the list corresponding to the sorted key
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values()); // Return the grouped anagrams
    }
}