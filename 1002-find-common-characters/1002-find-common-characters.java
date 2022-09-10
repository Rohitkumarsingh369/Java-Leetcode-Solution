class Solution {
    public List<String> commonChars(String[] words) {
        HashMap <Character , Integer> finalCount = new HashMap<>();
        for(char c = 'a' ; c <= 'z' ; ++c)
            finalCount.put(c , 100);
        HashMap <Character , Integer> count = new HashMap<>();
        for(String word : words)
        {
            count.clear();
            for(char c : word.toCharArray())
                count.put(c , count.getOrDefault(c , 0) + 1);
            for(char c = 'a' ; c <= 'z' ; ++c)
                finalCount.put(c , Math.min(finalCount.get(c) , count.getOrDefault(c , 0)));
        }
        List <String> result = new ArrayList<>();
        int times;
        for(char c = 'a' ; c <= 'z' ; ++c)
        {
            times = finalCount.get(c);
            while(times > 0)
            {
                result.add(Character.toString(c));
                --times;
            }
        }
        return result;
    }
}