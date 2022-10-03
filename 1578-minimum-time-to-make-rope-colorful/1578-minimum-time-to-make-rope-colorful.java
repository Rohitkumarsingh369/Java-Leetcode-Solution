class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        char prevColor = ' ';
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < colors.length(); i++) {
            char currColor = colors.charAt(i);
            int cost = neededTime[i];
            if (prevColor == ' ' || prevColor == currColor) {
                q.offer(cost);
            }
            if ((prevColor != ' ') && ((currColor != prevColor && q.size() > 0) || (i == colors.length() - 1))) {
                while (q.size() > 1) {
                    res += q.remove();
                }
                q.remove();
                q.offer(cost);
            }
            prevColor = currColor;
        }
        return res;
    }
}