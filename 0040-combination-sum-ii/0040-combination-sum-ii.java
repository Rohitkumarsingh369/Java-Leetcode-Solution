class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the candidates to handle duplicates
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: If target is 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add the current combination to the result
            return;
        }

        // Explore candidates starting from the current index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates (if the current candidate is the same as the previous one)
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If the candidate exceeds the target, stop further exploration
            if (candidates[i] > target) {
                break;
            }

            // Choose the candidate
            current.add(candidates[i]);

            // Recur with the reduced target and move to the next candidate
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}