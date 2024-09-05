class Solution {
   public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: if we have considered all elements
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, result);

        // Exclude the current element
        current.remove(current.size() - 1);
        generateSubsets(nums, index + 1, current, result);
    }
}