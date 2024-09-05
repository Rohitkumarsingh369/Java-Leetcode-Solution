class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Count frequencies of each number in nums1
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Find intersection with nums2
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        
        // Convert result list to array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        
        return intersection;  
    }
}