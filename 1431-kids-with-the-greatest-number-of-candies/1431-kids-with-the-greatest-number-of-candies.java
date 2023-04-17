class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
         int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
    }
}