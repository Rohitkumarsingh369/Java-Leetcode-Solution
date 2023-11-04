/*class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
	// count frequency of each number
	Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
	// custom sort
	return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
			.mapToInt(n -> n)
			.toArray();
    }
}*/
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int index=0;
        int[] res = new int[nums.length];

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : list) {
            for(int i=0; i<entry.getValue(); i++){
                res[index++]=entry.getKey();
            }
        }
        return res;
    }
}
/*
custom sort explanation:
.stream(nums)
iterates through the nums array

.boxed()
converts each int to Integer object, this is because .sorted() can only operate on objects

.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by decending numeric value

.mapToInt(n -> n)
converts Integer to int

.toArray()
returns array
*/