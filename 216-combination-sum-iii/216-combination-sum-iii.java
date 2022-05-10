class Solution {
   public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        combinationSum3Util(k, n, new ArrayList<>(), result, 1);
        return result;

    }

    private void combinationSum3Util(int k, int n, List<Integer> current, List<List<Integer>> result, int start) {

        if (n < 0) {
            return;
        }
        if (n == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            combinationSum3Util(k, n - i, current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }
}